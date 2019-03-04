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
public class AccountResourceTest {

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
	public void testAddAddress() {
		JSONObject jsonObject = _getAddressDTOJSONObject();

		testAddAddress(jsonObject);
	}

	public void testAddAddress(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}/address",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "city",
			equalTo(jsonObject.getString("city")), "commerceCountryId",
			equalTo(jsonObject.getString("commerceCountryId")),
			"commerceRegionId",
			equalTo(jsonObject.getString("commerceRegionId")), "defaultBilling",
			equalTo(jsonObject.getString("defaultBilling")), "defaultShipping",
			equalTo(jsonObject.getString("defaultShipping")), "description",
			equalTo(jsonObject.getString("description")), "latitude",
			equalTo(jsonObject.getString("latitude")), "longitude",
			equalTo(jsonObject.getString("longitude")), "name",
			equalTo(jsonObject.getString("name")), "phoneNumber",
			equalTo(jsonObject.getString("phoneNumber")), "street1",
			equalTo(jsonObject.getString("street1")), "street2",
			equalTo(jsonObject.getString("street2")), "street3",
			equalTo(jsonObject.getString("street3")), "zip",
			equalTo(jsonObject.getString("zip"))
		);
	}

	@Test
	public void testDeleteAccount() {
		JSONObject jsonObject = _getAccountDTOJSONObject();

		testUpsertAccount(jsonObject);

		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).delete(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}",
				jsonObject)
		).then(
		).statusCode(
			204
		);
	}

	@Test
	public void testGetAccount() {
		JSONObject jsonObject = _getAccountDTOJSONObject();

		testUpsertAccount(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "addresses",
			equalTo(jsonObject.getString("addresses")), "emailAddresses",
			equalTo(jsonObject.getString("emailAddresses")),
			"externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "logoId",
			equalTo(jsonObject.getString("logoId")), "name",
			equalTo(jsonObject.getString("name")), "organizations",
			equalTo(jsonObject.getString("organizations")), "root",
			equalTo(jsonObject.getString("root")), "taxId",
			equalTo(jsonObject.getString("taxId")), "type",
			equalTo(jsonObject.getString("type")), "users",
			equalTo(jsonObject.getString("users"))
		);
	}

	@Test
	public void testGetAccountOrders() {
		JSONObject jsonObject = _getOrderDTOJSONObject();

		testUpsertOrder(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}/order",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetAccounts() {
		JSONObject jsonObject = _getAccountDTOJSONObject();

		testUpsertAccount(jsonObject);

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
			"http://localhost:8080/o/commerce-admin/v2_0/account/"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetAddresses() {
		JSONObject jsonObject = _getAddressDTOJSONObject();

		testAddAddress(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}/address",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testUpdateAccount() {
		JSONObject jsonObject = _getAccountDTOJSONObject();

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
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}",
				jsonObject)
		).then(
		).statusCode(
			201
		);
	}

	@Test
	public void testUpsertAccount() {
		JSONObject jsonObject = _getAccountDTOJSONObject();

		testUpsertAccount(jsonObject);
	}

	public void testUpsertAccount(JSONObject jsonObject) {
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
			"http://localhost:8080/o/commerce-admin/v2_0/account/"
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "addresses",
			equalTo(jsonObject.getString("addresses")), "emailAddresses",
			equalTo(jsonObject.getString("emailAddresses")),
			"externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")), "logoId",
			equalTo(jsonObject.getString("logoId")), "name",
			equalTo(jsonObject.getString("name")), "organizations",
			equalTo(jsonObject.getString("organizations")), "root",
			equalTo(jsonObject.getString("root")), "taxId",
			equalTo(jsonObject.getString("taxId")), "type",
			equalTo(jsonObject.getString("type")), "users",
			equalTo(jsonObject.getString("users"))
		);
	}

	@Test
	public void testUpsertAccountLogo() {
		JSONObject jsonObject = _getAccountDTOJSONObject();

		testUpsertAccount(jsonObject);

		testUpsertAccountLogo(jsonObject);
	}

	public void testUpsertAccountLogo(JSONObject jsonObject) {
		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		).when(
		).post(
			replacePathParametersWithTestValues(
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}/logo/",
				jsonObject)
		).then(
		).statusCode(
			201
		);
	}

	@Test
	public void testUpsertOrder() {
		JSONObject jsonObject = _getOrderDTOJSONObject();

		testUpsertOrder(jsonObject);
	}

	public void testUpsertOrder(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/account/{id}/order",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "advanceStatus",
			equalTo(jsonObject.getString("advanceStatus")), "billingAddress",
			equalTo(jsonObject.getString("billingAddress")), "billingAddressId",
			equalTo(jsonObject.getString("billingAddressId")),
			"commerceAccountId",
			equalTo(jsonObject.getString("commerceAccountId")), "currency",
			equalTo(jsonObject.getString("currency")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"orderStatus", equalTo(jsonObject.getString("orderStatus")),
			"paymentMethod", equalTo(jsonObject.getString("paymentMethod")),
			"paymentStatus", equalTo(jsonObject.getString("paymentStatus")),
			"purchaseOrderNumber",
			equalTo(jsonObject.getString("purchaseOrderNumber")),
			"shippingAddress", equalTo(jsonObject.getString("shippingAddress")),
			"shippingAddressId",
			equalTo(jsonObject.getString("shippingAddressId")),
			"shippingAmount", equalTo(jsonObject.getString("shippingAmount")),
			"shippingMethod", equalTo(jsonObject.getString("shippingMethod")),
			"shippingOption", equalTo(jsonObject.getString("shippingOption")),
			"subtotal", equalTo(jsonObject.getString("subtotal")), "total",
			equalTo(jsonObject.getString("total"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

	private JSONObject _getAccountDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("addresses", 1);
		jsonObject.put("emailAddresses", 1);
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("logoId", 1);
		jsonObject.put("name", "test_value");
		jsonObject.put("organizations", 1);
		jsonObject.put("root", 1);
		jsonObject.put("taxId", "test_value");
		jsonObject.put("type", 1);
		jsonObject.put("users", 1);

		return jsonObject;
	}

	private JSONObject _getAddressDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("city", "test_value");
		jsonObject.put("commerceCountryId", 1);
		jsonObject.put("commerceRegionId", 1);
		jsonObject.put("defaultBilling", 1);
		jsonObject.put("defaultShipping", 1);
		jsonObject.put("description", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("latitude", 1);
		jsonObject.put("longitude", 1);
		jsonObject.put("name", "test_value");
		jsonObject.put("phoneNumber", "test_value");
		jsonObject.put("street1", "test_value");
		jsonObject.put("street2", "test_value");
		jsonObject.put("street3", "test_value");
		jsonObject.put("zip", "test_value");

		return jsonObject;
	}

	private JSONObject _getOrderDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("advanceStatus", "test_value");
		jsonObject.put("billingAddress", 1);
		jsonObject.put("billingAddressId", 1);
		jsonObject.put("commerceAccountId", 1);
		jsonObject.put("currency", "test_value");
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("orderStatus", 1);
		jsonObject.put("paymentMethod", "test_value");
		jsonObject.put("paymentStatus", 1);
		jsonObject.put("purchaseOrderNumber", "test_value");
		jsonObject.put("shippingAddress", 1);
		jsonObject.put("shippingAddressId", 1);
		jsonObject.put("shippingAmount", 1);
		jsonObject.put("shippingMethod", "test_value");
		jsonObject.put("shippingOption", "test_value");
		jsonObject.put("subtotal", 1);
		jsonObject.put("total", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}