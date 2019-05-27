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

package com.liferay.headless.commerce.admin.catalog.client.serdes.v1_0;

import com.liferay.headless.commerce.admin.catalog.client.dto.v1_0.ProductSubscriptionConfiguration;
import com.liferay.headless.commerce.admin.catalog.client.json.BaseJSONParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
public class ProductSubscriptionConfigurationSerDes {

	public static ProductSubscriptionConfiguration toDTO(String json) {
		ProductSubscriptionConfigurationJSONParser
			productSubscriptionConfigurationJSONParser =
				new ProductSubscriptionConfigurationJSONParser();

		return productSubscriptionConfigurationJSONParser.parseToDTO(json);
	}

	public static ProductSubscriptionConfiguration[] toDTOs(String json) {
		ProductSubscriptionConfigurationJSONParser
			productSubscriptionConfigurationJSONParser =
				new ProductSubscriptionConfigurationJSONParser();

		return productSubscriptionConfigurationJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		ProductSubscriptionConfiguration productSubscriptionConfiguration) {

		if (productSubscriptionConfiguration == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (productSubscriptionConfiguration.getEnable() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"enable\": ");

			sb.append(productSubscriptionConfiguration.getEnable());
		}

		if (productSubscriptionConfiguration.getLength() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"length\": ");

			sb.append(productSubscriptionConfiguration.getLength());
		}

		if (productSubscriptionConfiguration.getNumberOfLength() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"numberOfLength\": ");

			sb.append(productSubscriptionConfiguration.getNumberOfLength());
		}

		if (productSubscriptionConfiguration.getSubscriptionType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subscriptionType\": ");

			sb.append("\"");

			sb.append(productSubscriptionConfiguration.getSubscriptionType());

			sb.append("\"");
		}

		if (productSubscriptionConfiguration.getSubscriptionTypeSettings() !=
				null) {

			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subscriptionTypeSettings\": ");

			sb.append(
				_toJSON(
					productSubscriptionConfiguration.
						getSubscriptionTypeSettings()));
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductSubscriptionConfigurationJSONParser
			productSubscriptionConfigurationJSONParser =
				new ProductSubscriptionConfigurationJSONParser();

		return productSubscriptionConfigurationJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ProductSubscriptionConfiguration productSubscriptionConfiguration) {

		if (productSubscriptionConfiguration == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (productSubscriptionConfiguration.getEnable() == null) {
			map.put("enable", null);
		}
		else {
			map.put(
				"enable",
				String.valueOf(productSubscriptionConfiguration.getEnable()));
		}

		if (productSubscriptionConfiguration.getLength() == null) {
			map.put("length", null);
		}
		else {
			map.put(
				"length",
				String.valueOf(productSubscriptionConfiguration.getLength()));
		}

		if (productSubscriptionConfiguration.getNumberOfLength() == null) {
			map.put("numberOfLength", null);
		}
		else {
			map.put(
				"numberOfLength",
				String.valueOf(
					productSubscriptionConfiguration.getNumberOfLength()));
		}

		if (productSubscriptionConfiguration.getSubscriptionType() == null) {
			map.put("subscriptionType", null);
		}
		else {
			map.put(
				"subscriptionType",
				String.valueOf(
					productSubscriptionConfiguration.getSubscriptionType()));
		}

		if (productSubscriptionConfiguration.getSubscriptionTypeSettings() ==
				null) {

			map.put("subscriptionTypeSettings", null);
		}
		else {
			map.put(
				"subscriptionTypeSettings",
				String.valueOf(
					productSubscriptionConfiguration.
						getSubscriptionTypeSettings()));
		}

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static class ProductSubscriptionConfigurationJSONParser
		extends BaseJSONParser<ProductSubscriptionConfiguration> {

		@Override
		protected ProductSubscriptionConfiguration createDTO() {
			return new ProductSubscriptionConfiguration();
		}

		@Override
		protected ProductSubscriptionConfiguration[] createDTOArray(int size) {
			return new ProductSubscriptionConfiguration[size];
		}

		@Override
		protected void setField(
			ProductSubscriptionConfiguration productSubscriptionConfiguration,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "enable")) {
				if (jsonParserFieldValue != null) {
					productSubscriptionConfiguration.setEnable(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "length")) {
				if (jsonParserFieldValue != null) {
					productSubscriptionConfiguration.setLength(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "numberOfLength")) {
				if (jsonParserFieldValue != null) {
					productSubscriptionConfiguration.setNumberOfLength(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "subscriptionType")) {
				if (jsonParserFieldValue != null) {
					productSubscriptionConfiguration.setSubscriptionType(
						ProductSubscriptionConfiguration.SubscriptionType.
							create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "subscriptionTypeSettings")) {

				if (jsonParserFieldValue != null) {
					productSubscriptionConfiguration.
						setSubscriptionTypeSettings(
							ProductSubscriptionConfigurationSerDes.toMap(
								(String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}