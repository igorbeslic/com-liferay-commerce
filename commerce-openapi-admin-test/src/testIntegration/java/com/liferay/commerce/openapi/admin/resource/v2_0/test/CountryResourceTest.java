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
public class CountryResourceTest {

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
	public void testDeleteCountry() {
		JSONObject jsonObject = _getCountryDTOJSONObject();

		testUpsertCountry(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).delete(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/country/{id}",
				jsonObject)
		).then(
		).statusCode(
			204
		);
	}

	@Test
	public void testGetCountries() {
		JSONObject jsonObject = _getCountryDTOJSONObject();

		testUpsertCountry(jsonObject);

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
			"http://localhost:8080/o/commerce-admin/v2_0/country/"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetCountry() {
		JSONObject jsonObject = _getCountryDTOJSONObject();

		testUpsertCountry(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/country/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "billingAllowed",
			equalTo(jsonObject.getString("billingAllowed")), "name",
			equalTo(jsonObject.getString("name")), "numericISOCode",
			equalTo(jsonObject.getString("numericISOCode")), "regions",
			equalTo(jsonObject.getString("regions")), "shippingAllowed",
			equalTo(jsonObject.getString("shippingAllowed")), "subjectToVAT",
			equalTo(jsonObject.getString("subjectToVAT")),
			"threeLettersISOCode",
			equalTo(jsonObject.getString("threeLettersISOCode")),
			"twoLettersISOCode",
			equalTo(jsonObject.getString("twoLettersISOCode"))
		);
	}

	@Test
	public void testGetRegions() {
		JSONObject jsonObject = _getRegionDTOJSONObject();

		testUpsertRegion(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/country/{id}/region",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testUpdateCountry() {
		JSONObject jsonObject = _getCountryDTOJSONObject();

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
				"http://localhost:8080/o/commerce-admin/v2_0/country/{id}",
				jsonObject)
		).then(
		).statusCode(
			202
		);
	}

	@Test
	public void testUpsertCountry() {
		JSONObject jsonObject = _getCountryDTOJSONObject();

		testUpsertCountry(jsonObject);
	}

	public void testUpsertCountry(JSONObject jsonObject) {
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
			"http://localhost:8080/o/commerce-admin/v2_0/country/"
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "billingAllowed",
			equalTo(jsonObject.getString("billingAllowed")), "name",
			equalTo(jsonObject.getString("name")), "numericISOCode",
			equalTo(jsonObject.getString("numericISOCode")), "regions",
			equalTo(jsonObject.getString("regions")), "shippingAllowed",
			equalTo(jsonObject.getString("shippingAllowed")), "subjectToVAT",
			equalTo(jsonObject.getString("subjectToVAT")),
			"threeLettersISOCode",
			equalTo(jsonObject.getString("threeLettersISOCode")),
			"twoLettersISOCode",
			equalTo(jsonObject.getString("twoLettersISOCode"))
		);
	}

	@Test
	public void testUpsertRegion() {
		JSONObject jsonObject = _getRegionDTOJSONObject();

		testUpsertRegion(jsonObject);
	}

	public void testUpsertRegion(JSONObject jsonObject) {
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
		).when(
		).post(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/country/{id}/region",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"commerceCountryId",
			equalTo(jsonObject.getString("commerceCountryId")), "name",
			equalTo(jsonObject.getString("name")), "code",
			equalTo(jsonObject.getString("code")), "priority",
			equalTo(jsonObject.getString("priority")), "active",
			equalTo(jsonObject.getString("active")), "id",
			equalTo(jsonObject.getString("id"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getCountryDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("billingAllowed", 1);
		jsonObject.put("id", 1);
		jsonObject.put("name", 1);
		jsonObject.put("numericISOCode", 1);
		jsonObject.put("regions", 1);
		jsonObject.put("shippingAllowed", 1);
		jsonObject.put("subjectToVAT", 1);
		jsonObject.put("threeLettersISOCode", "test_value");
		jsonObject.put("twoLettersISOCode", "test_value");

		return jsonObject;
	}

	private JSONObject _getRegionDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("active", 1);
		jsonObject.put("code", "test_value");
		jsonObject.put("commerceCountryId", 1);
		jsonObject.put("id", 1);
		jsonObject.put("name", "test_value");
		jsonObject.put("priority", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}