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
public class ProductResourceTest {

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
	public void testDeleteProduct() {
		JSONObject jsonObject = _getProductDTOJSONObject();

		testUpsertProduct(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).delete(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/product/{id}",
				jsonObject)
		).then(
		).statusCode(
			204
		);
	}

	@Test
	public void testGetProduct() {
		JSONObject jsonObject = _getProductDTOJSONObject();

		testUpsertProduct(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/product/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"name", equalTo(jsonObject.getString("name")), "description",
			equalTo(jsonObject.getString("description")), "assetCategoryIds",
			equalTo(jsonObject.getString("assetCategoryIds")), "defaultSku",
			equalTo(jsonObject.getString("defaultSku")), "shortDescription",
			equalTo(jsonObject.getString("shortDescription")), "active",
			equalTo(jsonObject.getString("active")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"productTypeName", equalTo(jsonObject.getString("productTypeName")),
			"id", equalTo(jsonObject.getString("id")), "expando",
			equalTo(jsonObject.getString("expando")), "skus",
			equalTo(jsonObject.getString("skus"))
		);
	}

	@Test
	public void testGetProducts() {
		JSONObject jsonObject = _getProductDTOJSONObject();

		testUpsertProduct(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).accept(
			ContentType.fromContentType("application/json")
		).queryParam(
			"groupId", 1
		).when(
		).get(
			"http://localhost:8080/o/commerce-admin/v2_0/product/"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetSkus() {
		JSONObject jsonObject = _getSkuDTOJSONObject();

		testUpsertSku(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/product/{id}/sku",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testUpdateProduct() {
		JSONObject jsonObject = _getProductDTOJSONObject();

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).contentType(
			ContentType.fromContentType("application/json")
		).body(
			jsonObject.toString()
		).queryParam(
			"groupId", 1
		).when(
		).put(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/product/{id}",
				jsonObject)
		).then(
		).statusCode(
			201
		);
	}

	@Test
	public void testUpsertProduct() {
		JSONObject jsonObject = _getProductDTOJSONObject();

		testUpsertProduct(jsonObject);
	}

	public void testUpsertProduct(JSONObject jsonObject) {
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
			"http://localhost:8080/o/commerce-admin/v2_0/product/"
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"name", equalTo(jsonObject.getString("name")), "description",
			equalTo(jsonObject.getString("description")), "assetCategoryIds",
			equalTo(jsonObject.getString("assetCategoryIds")), "defaultSku",
			equalTo(jsonObject.getString("defaultSku")), "shortDescription",
			equalTo(jsonObject.getString("shortDescription")), "active",
			equalTo(jsonObject.getString("active")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"productTypeName", equalTo(jsonObject.getString("productTypeName")),
			"id", equalTo(jsonObject.getString("id")), "expando",
			equalTo(jsonObject.getString("expando")), "skus",
			equalTo(jsonObject.getString("skus"))
		);
	}

	@Test
	public void testUpsertSku() {
		JSONObject jsonObject = _getSkuDTOJSONObject();

		testUpsertSku(jsonObject);
	}

	public void testUpsertSku(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/product/{id}/sku",
				jsonObject)
		).then(
		).statusCode(
			201
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

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getProductDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("active", 1);
		jsonObject.put("assetCategoryIds", 1);
		jsonObject.put("defaultSku", "test_value");
		jsonObject.put("description", 1);
		jsonObject.put("expando", 1);
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("name", 1);
		jsonObject.put("productTypeName", "test_value");
		jsonObject.put("shortDescription", 1);
		jsonObject.put("skus", 1);

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