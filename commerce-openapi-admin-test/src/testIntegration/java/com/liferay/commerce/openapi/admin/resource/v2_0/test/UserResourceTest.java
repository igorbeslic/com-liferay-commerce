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
public class UserResourceTest {

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
	public void testDeleteUser() {
		JSONObject jsonObject = _getUserDTOJSONObject();

		testUpsertUser(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).delete(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/user/{id}",
				jsonObject)
		).then(
		).statusCode(
			204
		);
	}

	@Test
	public void testGetUser() {
		JSONObject jsonObject = _getUserDTOJSONObject();

		testUpsertUser(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/user/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "birthDate",
			equalTo(jsonObject.getString("birthDate")), "commerceAccountIds",
			equalTo(jsonObject.getString("commerceAccountIds")), "image",
			equalTo(jsonObject.getString("image")), "additionalName",
			equalTo(jsonObject.getString("additionalName")), "alternateName",
			equalTo(jsonObject.getString("alternateName")), "dashboardURL",
			equalTo(jsonObject.getString("dashboardURL")), "email",
			equalTo(jsonObject.getString("email")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"familyName", equalTo(jsonObject.getString("familyName")), "gender",
			equalTo(jsonObject.getString("gender")), "givenName",
			equalTo(jsonObject.getString("givenName")), "jobTitle",
			equalTo(jsonObject.getString("jobTitle")), "name",
			equalTo(jsonObject.getString("name")), "profileURL",
			equalTo(jsonObject.getString("profileURL")), "roleNames",
			equalTo(jsonObject.getString("roleNames"))
		);
	}

	@Test
	public void testGetUsers() {
		JSONObject jsonObject = _getUserDTOJSONObject();

		testUpsertUser(jsonObject);

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
			"http://localhost:8080/o/commerce-admin/v2_0/user/"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testUpdateUser() {
		JSONObject jsonObject = _getUserDTOJSONObject();

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
				"http://localhost:8080/o/commerce-admin/v2_0/user/{id}",
				jsonObject)
		).then(
		).statusCode(
			202
		);
	}

	@Test
	public void testUpsertUser() {
		JSONObject jsonObject = _getUserDTOJSONObject();

		testUpsertUser(jsonObject);
	}

	public void testUpsertUser(JSONObject jsonObject) {
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
			"http://localhost:8080/o/commerce-admin/v2_0/user/"
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "birthDate",
			equalTo(jsonObject.getString("birthDate")), "commerceAccountIds",
			equalTo(jsonObject.getString("commerceAccountIds")), "image",
			equalTo(jsonObject.getString("image")), "additionalName",
			equalTo(jsonObject.getString("additionalName")), "alternateName",
			equalTo(jsonObject.getString("alternateName")), "dashboardURL",
			equalTo(jsonObject.getString("dashboardURL")), "email",
			equalTo(jsonObject.getString("email")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"familyName", equalTo(jsonObject.getString("familyName")), "gender",
			equalTo(jsonObject.getString("gender")), "givenName",
			equalTo(jsonObject.getString("givenName")), "jobTitle",
			equalTo(jsonObject.getString("jobTitle")), "name",
			equalTo(jsonObject.getString("name")), "profileURL",
			equalTo(jsonObject.getString("profileURL")), "roleNames",
			equalTo(jsonObject.getString("roleNames"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getUserDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("additionalName", "test_value");
		jsonObject.put("alternateName", "test_value");
		jsonObject.put("birthDate", "test_value");
		jsonObject.put("commerceAccountIds", 1);
		jsonObject.put("dashboardURL", "test_value");
		jsonObject.put("email", "test_value");
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("familyName", "test_value");
		jsonObject.put("gender", "test_value");
		jsonObject.put("givenName", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("image", "test_value");
		jsonObject.put("jobTitle", "test_value");
		jsonObject.put("name", "test_value");
		jsonObject.put("profileURL", "test_value");
		jsonObject.put("roleNames", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}