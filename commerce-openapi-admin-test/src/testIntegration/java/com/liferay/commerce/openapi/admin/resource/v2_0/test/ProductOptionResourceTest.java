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
public class ProductOptionResourceTest {

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
	public void testDeleteProductOption() {
		JSONObject jsonObject = _getProductOptionDTOJSONObject();

		testUpsertProductOption(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).delete(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/productOption/{id}",
				jsonObject)
		).then(
		).statusCode(
			204
		);
	}

	@Test
	public void testGetProductOption() {
		JSONObject jsonObject = _getProductOptionDTOJSONObject();

		testUpsertProductOption(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/productOption/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"name", equalTo(jsonObject.getString("name")), "key",
			equalTo(jsonObject.getString("key")), "description",
			equalTo(jsonObject.getString("description")), "facetable",
			equalTo(jsonObject.getString("facetable")), "required",
			equalTo(jsonObject.getString("required")), "skuContributor",
			equalTo(jsonObject.getString("skuContributor")), "fieldType",
			equalTo(jsonObject.getString("fieldType")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "id",
			equalTo(jsonObject.getString("id"))
		);
	}

	@Test
	public void testGetProductOptions() {
		JSONObject jsonObject = _getProductOptionDTOJSONObject();

		testUpsertProductOption(jsonObject);

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
			"http://localhost:8080/o/commerce-admin/v2_0/productOption/"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetProductOptionValues() {
		JSONObject jsonObject = _getProductOptionValueDTOJSONObject();

		testUpsertProductOptionValue(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/productOption/{id}/productOptionValue",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testUpdateProductOption() {
		JSONObject jsonObject = _getProductOptionDTOJSONObject();

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
				"http://localhost:8080/o/commerce-admin/v2_0/productOption/{id}",
				jsonObject)
		).then(
		).statusCode(
			201
		);
	}

	@Test
	public void testUpsertProductOption() {
		JSONObject jsonObject = _getProductOptionDTOJSONObject();

		testUpsertProductOption(jsonObject);
	}

	public void testUpsertProductOption(JSONObject jsonObject) {
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
			"http://localhost:8080/o/commerce-admin/v2_0/productOption/"
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"name", equalTo(jsonObject.getString("name")), "key",
			equalTo(jsonObject.getString("key")), "description",
			equalTo(jsonObject.getString("description")), "facetable",
			equalTo(jsonObject.getString("facetable")), "required",
			equalTo(jsonObject.getString("required")), "skuContributor",
			equalTo(jsonObject.getString("skuContributor")), "fieldType",
			equalTo(jsonObject.getString("fieldType")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "id",
			equalTo(jsonObject.getString("id"))
		);
	}

	@Test
	public void testUpsertProductOptionValue() {
		JSONObject jsonObject = _getProductOptionValueDTOJSONObject();

		testUpsertProductOptionValue(jsonObject);
	}

	public void testUpsertProductOptionValue(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/productOption/{id}/productOptionValue",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"name", equalTo(jsonObject.getString("name")), "key",
			equalTo(jsonObject.getString("key")), "priority",
			equalTo(jsonObject.getString("priority")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "id",
			equalTo(jsonObject.getString("id"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getProductOptionDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("description", "test_value");
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("facetable", 1);
		jsonObject.put("fieldType", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("key", "test_value");
		jsonObject.put("name", "test_value");
		jsonObject.put("required", 1);
		jsonObject.put("skuContributor", 1);

		return jsonObject;
	}

	private JSONObject _getProductOptionValueDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("key", "test_value");
		jsonObject.put("name", "test_value");
		jsonObject.put("priority", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}