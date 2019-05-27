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

import com.liferay.headless.commerce.admin.catalog.client.dto.v1_0.ProductOptionValue;
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
public class ProductOptionValueSerDes {

	public static ProductOptionValue toDTO(String json) {
		ProductOptionValueJSONParser productOptionValueJSONParser =
			new ProductOptionValueJSONParser();

		return productOptionValueJSONParser.parseToDTO(json);
	}

	public static ProductOptionValue[] toDTOs(String json) {
		ProductOptionValueJSONParser productOptionValueJSONParser =
			new ProductOptionValueJSONParser();

		return productOptionValueJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProductOptionValue productOptionValue) {
		if (productOptionValue == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (productOptionValue.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(productOptionValue.getId());
		}

		if (productOptionValue.getKey() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"key\": ");

			sb.append("\"");

			sb.append(_escape(productOptionValue.getKey()));

			sb.append("\"");
		}

		if (productOptionValue.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append(_toJSON(productOptionValue.getName()));
		}

		if (productOptionValue.getPriority() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"priority\": ");

			sb.append(productOptionValue.getPriority());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductOptionValueJSONParser productOptionValueJSONParser =
			new ProductOptionValueJSONParser();

		return productOptionValueJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ProductOptionValue productOptionValue) {

		if (productOptionValue == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (productOptionValue.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(productOptionValue.getId()));
		}

		if (productOptionValue.getKey() == null) {
			map.put("key", null);
		}
		else {
			map.put("key", String.valueOf(productOptionValue.getKey()));
		}

		if (productOptionValue.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(productOptionValue.getName()));
		}

		if (productOptionValue.getPriority() == null) {
			map.put("priority", null);
		}
		else {
			map.put(
				"priority", String.valueOf(productOptionValue.getPriority()));
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

	private static class ProductOptionValueJSONParser
		extends BaseJSONParser<ProductOptionValue> {

		@Override
		protected ProductOptionValue createDTO() {
			return new ProductOptionValue();
		}

		@Override
		protected ProductOptionValue[] createDTOArray(int size) {
			return new ProductOptionValue[size];
		}

		@Override
		protected void setField(
			ProductOptionValue productOptionValue, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					productOptionValue.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "key")) {
				if (jsonParserFieldValue != null) {
					productOptionValue.setKey((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					productOptionValue.setName(
						ProductOptionValueSerDes.toMap(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "priority")) {
				if (jsonParserFieldValue != null) {
					productOptionValue.setPriority(
						(Double)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}