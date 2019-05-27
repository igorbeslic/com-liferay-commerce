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

import com.liferay.headless.commerce.admin.catalog.client.dto.v1_0.SpecificationValue;
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
public class SpecificationValueSerDes {

	public static SpecificationValue toDTO(String json) {
		SpecificationValueJSONParser specificationValueJSONParser =
			new SpecificationValueJSONParser();

		return specificationValueJSONParser.parseToDTO(json);
	}

	public static SpecificationValue[] toDTOs(String json) {
		SpecificationValueJSONParser specificationValueJSONParser =
			new SpecificationValueJSONParser();

		return specificationValueJSONParser.parseToDTOs(json);
	}

	public static String toJSON(SpecificationValue specificationValue) {
		if (specificationValue == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (specificationValue.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(specificationValue.getId());
		}

		if (specificationValue.getOptionCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"optionCategory\": ");

			sb.append(String.valueOf(specificationValue.getOptionCategory()));
		}

		if (specificationValue.getPriority() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"priority\": ");

			sb.append(specificationValue.getPriority());
		}

		if (specificationValue.getProduct() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"product\": ");

			sb.append(String.valueOf(specificationValue.getProduct()));
		}

		if (specificationValue.getSpecification() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specification\": ");

			sb.append(String.valueOf(specificationValue.getSpecification()));
		}

		if (specificationValue.getValue() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"value\": ");

			sb.append(_toJSON(specificationValue.getValue()));
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SpecificationValueJSONParser specificationValueJSONParser =
			new SpecificationValueJSONParser();

		return specificationValueJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		SpecificationValue specificationValue) {

		if (specificationValue == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (specificationValue.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(specificationValue.getId()));
		}

		if (specificationValue.getOptionCategory() == null) {
			map.put("optionCategory", null);
		}
		else {
			map.put(
				"optionCategory",
				String.valueOf(specificationValue.getOptionCategory()));
		}

		if (specificationValue.getPriority() == null) {
			map.put("priority", null);
		}
		else {
			map.put(
				"priority", String.valueOf(specificationValue.getPriority()));
		}

		if (specificationValue.getProduct() == null) {
			map.put("product", null);
		}
		else {
			map.put("product", String.valueOf(specificationValue.getProduct()));
		}

		if (specificationValue.getSpecification() == null) {
			map.put("specification", null);
		}
		else {
			map.put(
				"specification",
				String.valueOf(specificationValue.getSpecification()));
		}

		if (specificationValue.getValue() == null) {
			map.put("value", null);
		}
		else {
			map.put("value", String.valueOf(specificationValue.getValue()));
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

	private static class SpecificationValueJSONParser
		extends BaseJSONParser<SpecificationValue> {

		@Override
		protected SpecificationValue createDTO() {
			return new SpecificationValue();
		}

		@Override
		protected SpecificationValue[] createDTOArray(int size) {
			return new SpecificationValue[size];
		}

		@Override
		protected void setField(
			SpecificationValue specificationValue, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					specificationValue.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "optionCategory")) {
				if (jsonParserFieldValue != null) {
					specificationValue.setOptionCategory(
						OptionCategorySerDes.toDTO(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "priority")) {
				if (jsonParserFieldValue != null) {
					specificationValue.setPriority(
						(Double)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "product")) {
				if (jsonParserFieldValue != null) {
					specificationValue.setProduct(
						ProductSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "specification")) {
				if (jsonParserFieldValue != null) {
					specificationValue.setSpecification(
						SpecificationSerDes.toDTO(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "value")) {
				if (jsonParserFieldValue != null) {
					specificationValue.setValue(
						SpecificationValueSerDes.toMap(
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