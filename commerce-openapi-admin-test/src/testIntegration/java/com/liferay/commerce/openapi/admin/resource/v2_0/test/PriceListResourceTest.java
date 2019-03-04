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
public class PriceListResourceTest {

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
	public void testDeletePriceList() {
		JSONObject jsonObject = _getPriceListDTOJSONObject();

		testUpsertPriceList(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).delete(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/priceList/{id}",
				jsonObject)
		).then(
		).statusCode(
			204
		);
	}

	@Test
	public void testGetPriceList() {
		JSONObject jsonObject = _getPriceListDTOJSONObject();

		testUpsertPriceList(jsonObject);

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
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/priceList/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"displayDate", equalTo(jsonObject.getString("displayDate")),
			"expirationDate", equalTo(jsonObject.getString("expirationDate")),
			"commercePriceListId",
			equalTo(jsonObject.getString("commercePriceListId")), "neverExpire",
			equalTo(jsonObject.getString("neverExpire")), "priority",
			equalTo(jsonObject.getString("priority")), "active",
			equalTo(jsonObject.getString("active")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "currency",
			equalTo(jsonObject.getString("currency")), "name",
			equalTo(jsonObject.getString("name")), "id",
			equalTo(jsonObject.getString("id"))
		);
	}

	@Test
	public void testGetPriceLists() {
		JSONObject jsonObject = _getPriceListDTOJSONObject();

		testUpsertPriceList(jsonObject);

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
			"http://localhost:8080/o/commerce-admin/v2_0/priceList/"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testUpdatePriceList() {
		JSONObject jsonObject = _getPriceListDTOJSONObject();

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
				"http://localhost:8080/o/commerce-admin/v2_0/priceList/{id}",
				jsonObject)
		).then(
		).statusCode(
			201
		);
	}

	@Test
	public void testUpsertPriceList() {
		JSONObject jsonObject = _getPriceListDTOJSONObject();

		testUpsertPriceList(jsonObject);
	}

	public void testUpsertPriceList(JSONObject jsonObject) {
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
			"http://localhost:8080/o/commerce-admin/v2_0/priceList/"
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"displayDate", equalTo(jsonObject.getString("displayDate")),
			"expirationDate", equalTo(jsonObject.getString("expirationDate")),
			"commercePriceListId",
			equalTo(jsonObject.getString("commercePriceListId")), "neverExpire",
			equalTo(jsonObject.getString("neverExpire")), "priority",
			equalTo(jsonObject.getString("priority")), "active",
			equalTo(jsonObject.getString("active")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "currency",
			equalTo(jsonObject.getString("currency")), "name",
			equalTo(jsonObject.getString("name")), "id",
			equalTo(jsonObject.getString("id"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getPriceListDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("active", 1);
		jsonObject.put("commercePriceListId", 1);
		jsonObject.put("currency", "test_value");
		jsonObject.put("displayDate", "test_value");
		jsonObject.put("expirationDate", "test_value");
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("name", "test_value");
		jsonObject.put("neverExpire", 1);
		jsonObject.put("priority", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}