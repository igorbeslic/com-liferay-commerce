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
public class PriceEntryResourceTest {

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
	public void testDeletePriceEntry() {
		JSONObject jsonObject = _getPriceEntryDTOJSONObject();

		testUpsertPriceEntry(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).delete(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/priceEntry/{id}",
				jsonObject)
		).then(
		).statusCode(
			204
		);
	}

	@Test
	public void testGetPriceEntries() {
		JSONObject jsonObject = _getPriceEntryDTOJSONObject();

		testUpsertPriceEntry(jsonObject);

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
			"http://localhost:8080/o/commerce-admin/v2_0/priceEntry/"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetPriceEntry() {
		JSONObject jsonObject = _getPriceEntryDTOJSONObject();

		testUpsertPriceEntry(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/priceEntry/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "commercePriceListId",
			equalTo(jsonObject.getString("commercePriceListId")),
			"commerceProductInstanceId",
			equalTo(jsonObject.getString("commerceProductInstanceId")),
			"hasTierPrice", equalTo(jsonObject.getString("hasTierPrice")),
			"standardPrice", equalTo(jsonObject.getString("standardPrice")),
			"price", equalTo(jsonObject.getString("price")), "promoPrice",
			equalTo(jsonObject.getString("promoPrice")),
			"externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"skuExternalReferenceCode",
			equalTo(jsonObject.getString("skuExternalReferenceCode")), "sku",
			equalTo(jsonObject.getString("sku"))
		);
	}

	@Test
	public void testUpdatePriceEntry() {
		JSONObject jsonObject = _getPriceEntryDTOJSONObject();

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
		).when(
		).put(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/priceEntry/{id}",
				jsonObject)
		).then(
		).statusCode(
			202
		);
	}

	@Test
	public void testUpsertPriceEntry() {
		JSONObject jsonObject = _getPriceEntryDTOJSONObject();

		testUpsertPriceEntry(jsonObject);
	}

	public void testUpsertPriceEntry(JSONObject jsonObject) {
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
			"http://localhost:8080/o/commerce-admin/v2_0/priceEntry/"
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "commercePriceListId",
			equalTo(jsonObject.getString("commercePriceListId")),
			"commerceProductInstanceId",
			equalTo(jsonObject.getString("commerceProductInstanceId")),
			"hasTierPrice", equalTo(jsonObject.getString("hasTierPrice")),
			"standardPrice", equalTo(jsonObject.getString("standardPrice")),
			"price", equalTo(jsonObject.getString("price")), "promoPrice",
			equalTo(jsonObject.getString("promoPrice")),
			"externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"skuExternalReferenceCode",
			equalTo(jsonObject.getString("skuExternalReferenceCode")), "sku",
			equalTo(jsonObject.getString("sku"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getPriceEntryDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("commercePriceListId", 1);
		jsonObject.put("commerceProductInstanceId", 1);
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("hasTierPrice", 1);
		jsonObject.put("id", 1);
		jsonObject.put("price", 1);
		jsonObject.put("promoPrice", 1);
		jsonObject.put("sku", "test_value");
		jsonObject.put("skuExternalReferenceCode", "test_value");
		jsonObject.put("standardPrice", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}