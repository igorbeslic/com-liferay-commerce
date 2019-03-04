/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.openapi.admin.resource.v2_0.test;

import static org.hamcrest.CoreMatchers.equalTo;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Generated;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Igor Beslic
 */
@Generated(value = "OSGiRESTModuleGenerator")
@RunWith(Arquillian.class)
public class SkuResourceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	public String replacePathParametersWithTestValues(
		String path, JSONObject jsonObject) {

		String pathWithReplacedParameters = path;

		Pattern parameterPattern = Pattern.compile("\\{([a-zA-Z0-9]+)\\}");

		Matcher matcher = parameterPattern.matcher(path);

		while (matcher.find()) {
			String pathParameterName = matcher.group(1);

			pathWithReplacedParameters = pathWithReplacedParameters.replace(
				pathParameterName, jsonObject.getString(pathParameterName));
		}

		return pathWithReplacedParameters;
	}

	@Test
	public void testGetInventories() {
		JSONObject jsonObject = _getInventoryDTOJSONObject();

		testUpsertInventory(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).accept(
			ContentType.fromContentType("application/json")
		).when(
		).get(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/sku/{id}/inventory",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetSku() {
		JSONObject jsonObject = _getSkuDTOJSONObject();

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).accept(
			ContentType.fromContentType("application/json")
		).when(
		).get(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/sku/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"neverExpire", equalTo(jsonObject.getString("neverExpire")),
			"published", equalTo(jsonObject.getString("published")),
			"purchasable", equalTo(jsonObject.getString("purchasable")), "cost",
			equalTo(jsonObject.getString("cost")), "depth",
			equalTo(jsonObject.getString("depth")), "height",
			equalTo(jsonObject.getString("height")), "price",
			equalTo(jsonObject.getString("price")), "promoPrice",
			equalTo(jsonObject.getString("promoPrice")), "weight",
			equalTo(jsonObject.getString("weight")), "width",
			equalTo(jsonObject.getString("width")), "displayDate",
			equalTo(jsonObject.getString("displayDate")), "expirationDate",
			equalTo(jsonObject.getString("expirationDate")), "gtin",
			equalTo(jsonObject.getString("gtin")), "manufacturerPartNumber",
			equalTo(jsonObject.getString("manufacturerPartNumber")), "sku",
			equalTo(jsonObject.getString("sku")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "id",
			equalTo(jsonObject.getString("id"))
		);
	}

	@Test
	public void testUpsertInventory() {
		JSONObject jsonObject = _getInventoryDTOJSONObject();

		testUpsertInventory(jsonObject);
	}

	public void testUpsertInventory(JSONObject jsonObject) {
		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).accept(
			ContentType.fromContentType("application/json")
		).contentType(
			ContentType.fromContentType("application/json")
		).body(
			jsonObject.toString()
		).queryParam(
			"groupId", 1
		).when(
		).post(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/sku/{id}/inventory",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "quantity",
			equalTo(jsonObject.getString("quantity")),
			"skuExternalReferenceCode",
			equalTo(jsonObject.getString("skuExternalReferenceCode")), "skuId",
			equalTo(jsonObject.getString("skuId")), "warehouseId",
			equalTo(jsonObject.getString("warehouseId")), "warehouseName",
			equalTo(jsonObject.getString("warehouseName"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getInventoryDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("id", 1);
		jsonObject.put("quantity", 1);
		jsonObject.put("skuExternalReferenceCode", "test_value");
		jsonObject.put("skuId", 1);
		jsonObject.put("warehouseId", 1);
		jsonObject.put("warehouseName", "test_value");

		return jsonObject;
	}

	private JSONObject _getSkuDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("cost", 1);
		jsonObject.put("depth", 1);
		jsonObject.put("displayDate", "test_value");
		jsonObject.put("expirationDate", "test_value");
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("gtin", "test_value");
		jsonObject.put("height", 1);
		jsonObject.put("id", 1);
		jsonObject.put("manufacturerPartNumber", "test_value");
		jsonObject.put("neverExpire", 1);
		jsonObject.put("price", 1);
		jsonObject.put("promoPrice", 1);
		jsonObject.put("published", 1);
		jsonObject.put("purchasable", 1);
		jsonObject.put("sku", "test_value");
		jsonObject.put("weight", 1);
		jsonObject.put("width", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}