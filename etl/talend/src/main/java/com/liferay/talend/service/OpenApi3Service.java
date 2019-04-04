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

package com.liferay.talend.service;

import com.liferay.talend.client.SwaggerHubClient;
import com.liferay.talend.dataset.OpenApi3DataSet;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.service.Service;
import org.talend.sdk.component.api.service.completion.DynamicValues;
import org.talend.sdk.component.api.service.completion.SuggestionValues;
import org.talend.sdk.component.api.service.completion.Suggestions;
import org.talend.sdk.component.api.service.completion.Values;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Igor Beslic
 */
@Service
public class OpenApi3Service {

	@Suggestions("OpenApi3ConnectionApiKey")
	public SuggestionValues suggestApiKeyValues() {
		SuggestionValues suggestionValues = new SuggestionValues();

		Set<SuggestionValues.Item> items = new HashSet<>();

		items.add(
			new SuggestionValues.Item(
				"e4e33e24-eebf-45a4-bbab-4473a3a767ab",
				"liferay.swagger.api.key"));
		items.add(
			new SuggestionValues.Item(
				"e4e33e24-eebf-45a4-bbab-4473a3a767ab",
				"liferay.swagger.api.key.backup"));

		suggestionValues.setItems(items);

		return suggestionValues;
	}

	@Suggestions("OpenApi3Paths")
	public SuggestionValues suggestOpenApi3PathValues(
		@Option("configuration") final OpenApi3DataSet openApi3DataSet,
		final SwaggerHubClient swaggerHubClient) {

		System.out.println(
			"[" + this + "] openApiDataSet   : " + openApi3DataSet);
		System.out.println(
			"[" + this + "] swaggerHubClient : " + swaggerHubClient);

		SuggestionValues suggestionValues = new SuggestionValues();

		Set<SuggestionValues.Item> items = new HashSet<>();

		items.add(
			new SuggestionValues.Item(
				"/path/one", "The First Path"));
		items.add(
			new SuggestionValues.Item(
				"/path/second", "The Second Path"));

		suggestionValues.setItems(items);

		return suggestionValues;
	}

	@DynamicValues(value = "OpenApi3ConnectionEndpointInstanceUrl")
	public Values proposeEndpointInstanceURLValues() {
		Set<Values.Item> items = new HashSet<>();

		items.add(new Values.Item("https://api.swaggerhub.com",
			"liferay.swagger.api.endpoint.instance.url"));
		items.add(new Values.Item("https://api.swaggerhub.com",
			"liferay.swagger.api.endpoint.instance.url.backup"));

		Values values = new Values(items);

		return values;
	}

}
