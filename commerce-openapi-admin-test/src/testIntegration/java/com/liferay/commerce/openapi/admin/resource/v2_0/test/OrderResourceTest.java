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
public class OrderResourceTest {

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
	public void testGetBillingAddress() {
		JSONObject jsonObject = _getAddressDTOJSONObject();

		testUpdateBillingAddress(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/billingAddress",
				jsonObject)
		).then(
		).statusCode(
			200
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
	public void testGetOrder() {
		JSONObject jsonObject = _getOrderDTOJSONObject();

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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}",
				jsonObject)
		).then(
		).statusCode(
			200
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

	@Test
	public void testGetOrderItem() {
		JSONObject jsonObject = _getOrderItemDTOJSONObject();

		testUpdateOrderItem(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderItem/{orderItemId}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "commerceOrderId",
			equalTo(jsonObject.getString("commerceOrderId")), "discountAmount",
			equalTo(jsonObject.getString("discountAmount")),
			"externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"finalPrice", equalTo(jsonObject.getString("finalPrice")), "name",
			equalTo(jsonObject.getString("name")), "quantity",
			equalTo(jsonObject.getString("quantity")), "shippedQuantity",
			equalTo(jsonObject.getString("shippedQuantity")), "sku",
			equalTo(jsonObject.getString("sku")), "skuId",
			equalTo(jsonObject.getString("skuId")), "subscription",
			equalTo(jsonObject.getString("subscription")), "unitPrice",
			equalTo(jsonObject.getString("unitPrice"))
		);
	}

	@Test
	public void testGetOrderItems() {
		JSONObject jsonObject = _getOrderItemDTOJSONObject();

		testUpdateOrderItem(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderItem",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetOrderNote() {
		JSONObject jsonObject = _getOrderNoteDTOJSONObject();

		testUpdateOrderNote(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderNote/{orderNoteId}",
				jsonObject)
		).then(
		).statusCode(
			200
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "author",
			equalTo(jsonObject.getString("author")), "commerceOrderId",
			equalTo(jsonObject.getString("commerceOrderId")), "content",
			equalTo(jsonObject.getString("content")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"restricted", equalTo(jsonObject.getString("restricted"))
		);
	}

	@Test
	public void testGetOrderNotes() {
		JSONObject jsonObject = _getOrderNoteDTOJSONObject();

		testUpdateOrderNote(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderNote",
				jsonObject)
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetOrders() {
		JSONObject jsonObject = _getOrderDTOJSONObject();

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
			"http://localhost:8080/o/commerce-admin/v2_0/order"
		).then(
		).statusCode(
			200
		);

		// TODO: implement pagination object validation;

	}

	@Test
	public void testGetShippingAddress() {
		JSONObject jsonObject = _getAddressDTOJSONObject();

		testUpdateBillingAddress(jsonObject);

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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/shippingAddress",
				jsonObject)
		).then(
		).statusCode(
			200
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
	public void testUpdateBillingAddress() {
		JSONObject jsonObject = _getAddressDTOJSONObject();

		testUpdateBillingAddress(jsonObject);
	}

	public void testUpdateBillingAddress(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/billingAddress",
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

	@Test
	public void testUpdateOrderItem() {
		JSONObject jsonObject = _getOrderItemDTOJSONObject();

		testUpdateOrderItem(jsonObject);
	}

	public void testUpdateOrderItem(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderItem/{orderItemId}",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "commerceOrderId",
			equalTo(jsonObject.getString("commerceOrderId")), "discountAmount",
			equalTo(jsonObject.getString("discountAmount")),
			"externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"finalPrice", equalTo(jsonObject.getString("finalPrice")), "name",
			equalTo(jsonObject.getString("name")), "quantity",
			equalTo(jsonObject.getString("quantity")), "shippedQuantity",
			equalTo(jsonObject.getString("shippedQuantity")), "sku",
			equalTo(jsonObject.getString("sku")), "skuId",
			equalTo(jsonObject.getString("skuId")), "subscription",
			equalTo(jsonObject.getString("subscription")), "unitPrice",
			equalTo(jsonObject.getString("unitPrice"))
		);
	}

	@Test
	public void testUpdateOrderNote() {
		JSONObject jsonObject = _getOrderNoteDTOJSONObject();

		testUpdateOrderNote(jsonObject);
	}

	public void testUpdateOrderNote(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderNote/{orderNoteId}",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "author",
			equalTo(jsonObject.getString("author")), "commerceOrderId",
			equalTo(jsonObject.getString("commerceOrderId")), "content",
			equalTo(jsonObject.getString("content")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"restricted", equalTo(jsonObject.getString("restricted"))
		);
	}

	@Test
	public void testUpdateShippingAddress() {
		JSONObject jsonObject = _getAddressDTOJSONObject();

		testUpdateShippingAddress(jsonObject);
	}

	public void testUpdateShippingAddress(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/shippingAddress",
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

	@Test
	public void testUpsertOrderItem() {
		JSONObject jsonObject = _getOrderItemDTOJSONObject();

		testUpsertOrderItem(jsonObject);
	}

	public void testUpsertOrderItem(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderItem",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "commerceOrderId",
			equalTo(jsonObject.getString("commerceOrderId")), "discountAmount",
			equalTo(jsonObject.getString("discountAmount")),
			"externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"finalPrice", equalTo(jsonObject.getString("finalPrice")), "name",
			equalTo(jsonObject.getString("name")), "quantity",
			equalTo(jsonObject.getString("quantity")), "shippedQuantity",
			equalTo(jsonObject.getString("shippedQuantity")), "sku",
			equalTo(jsonObject.getString("sku")), "skuId",
			equalTo(jsonObject.getString("skuId")), "subscription",
			equalTo(jsonObject.getString("subscription")), "unitPrice",
			equalTo(jsonObject.getString("unitPrice"))
		);
	}

	@Test
	public void testUpsertOrderNote() {
		JSONObject jsonObject = _getOrderNoteDTOJSONObject();

		testUpsertOrderNote(jsonObject);
	}

	public void testUpsertOrderNote(JSONObject jsonObject) {
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
				"http://localhost:8080/o/commerce-admin/v2_0/order/{id}/orderNote",
				jsonObject)
		).then(
		).statusCode(
			201
		).assertThat(
		).body(
			"id", equalTo(jsonObject.getString("id")), "author",
			equalTo(jsonObject.getString("author")), "commerceOrderId",
			equalTo(jsonObject.getString("commerceOrderId")), "content",
			equalTo(jsonObject.getString("content")), "externalReferenceCode",
			equalTo(jsonObject.getString("externalReferenceCode")),
			"restricted", equalTo(jsonObject.getString("restricted"))
		);
	}

	protected static final String PASSWORD = "test";

	protected static final String USER = "test@liferay.com";

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

	private JSONObject _getOrderItemDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("commerceOrderId", 1);
		jsonObject.put("discountAmount", 1);
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("finalPrice", 1);
		jsonObject.put("id", 1);
		jsonObject.put("name", 1);
		jsonObject.put("quantity", 1);
		jsonObject.put("shippedQuantity", 1);
		jsonObject.put("sku", "test_value");
		jsonObject.put("skuId", 1);
		jsonObject.put("subscription", 1);
		jsonObject.put("unitPrice", 1);

		return jsonObject;
	}

	private JSONObject _getOrderNoteDTOJSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("author", "test_value");
		jsonObject.put("commerceOrderId", 1);
		jsonObject.put("content", "test_value");
		jsonObject.put("externalReferenceCode", "test_value");
		jsonObject.put("id", 1);
		jsonObject.put("restricted", 1);

		return jsonObject;
	}

	@Inject
	private JSONFactory _jsonFactory;

}