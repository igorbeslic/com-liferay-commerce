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

import com.liferay.headless.commerce.admin.catalog.client.dto.v1_0.RelatedProduct;
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
public class RelatedProductSerDes {

	public static RelatedProduct toDTO(String json) {
		RelatedProductJSONParser relatedProductJSONParser =
			new RelatedProductJSONParser();

		return relatedProductJSONParser.parseToDTO(json);
	}

	public static RelatedProduct[] toDTOs(String json) {
		RelatedProductJSONParser relatedProductJSONParser =
			new RelatedProductJSONParser();

		return relatedProductJSONParser.parseToDTOs(json);
	}

	public static String toJSON(RelatedProduct relatedProduct) {
		if (relatedProduct == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (relatedProduct.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(relatedProduct.getId());
		}

		if (relatedProduct.getPriority() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"priority\": ");

			sb.append(relatedProduct.getPriority());
		}

		if (relatedProduct.getProduct() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"product\": ");

			sb.append(String.valueOf(relatedProduct.getProduct()));
		}

		if (relatedProduct.getProductId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productId\": ");

			sb.append(relatedProduct.getProductId());
		}

		if (relatedProduct.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(relatedProduct.getType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		RelatedProductJSONParser relatedProductJSONParser =
			new RelatedProductJSONParser();

		return relatedProductJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(RelatedProduct relatedProduct) {
		if (relatedProduct == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (relatedProduct.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(relatedProduct.getId()));
		}

		if (relatedProduct.getPriority() == null) {
			map.put("priority", null);
		}
		else {
			map.put("priority", String.valueOf(relatedProduct.getPriority()));
		}

		if (relatedProduct.getProduct() == null) {
			map.put("product", null);
		}
		else {
			map.put("product", String.valueOf(relatedProduct.getProduct()));
		}

		if (relatedProduct.getProductId() == null) {
			map.put("productId", null);
		}
		else {
			map.put("productId", String.valueOf(relatedProduct.getProductId()));
		}

		if (relatedProduct.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(relatedProduct.getType()));
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

	private static class RelatedProductJSONParser
		extends BaseJSONParser<RelatedProduct> {

		@Override
		protected RelatedProduct createDTO() {
			return new RelatedProduct();
		}

		@Override
		protected RelatedProduct[] createDTOArray(int size) {
			return new RelatedProduct[size];
		}

		@Override
		protected void setField(
			RelatedProduct relatedProduct, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					relatedProduct.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "priority")) {
				if (jsonParserFieldValue != null) {
					relatedProduct.setPriority((Double)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "product")) {
				if (jsonParserFieldValue != null) {
					relatedProduct.setProduct(
						ProductSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "productId")) {
				if (jsonParserFieldValue != null) {
					relatedProduct.setProductId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					relatedProduct.setType((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}