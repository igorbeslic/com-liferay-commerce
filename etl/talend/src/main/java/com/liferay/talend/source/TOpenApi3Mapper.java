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

package com.liferay.talend.source;

import com.liferay.talend.client.SwaggerHubClient;
import com.liferay.talend.dataset.OpenApi3DataSet;

import com.liferay.talend.datastore.OpenApi3Connection;
import org.talend.sdk.component.api.component.Icon;
import org.talend.sdk.component.api.component.Version;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.input.Assessor;
import org.talend.sdk.component.api.input.Emitter;
import org.talend.sdk.component.api.input.PartitionMapper;
import org.talend.sdk.component.api.input.PartitionSize;
import org.talend.sdk.component.api.input.Split;
import org.talend.sdk.component.api.meta.Documentation;
import org.talend.sdk.component.api.service.record.RecordBuilderFactory;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * @author Igor Beslic
 */
@Documentation("Gets OpenApi Specification JSON")
@Icon(value = Icon.IconType.STAR)
@PartitionMapper(name = "tOpenApi3Mapper")
@Version(1)
public class TOpenApi3Mapper implements Serializable {

    public TOpenApi3Mapper(
		@Option("configuration") final TOpenApi3MapperConfiguration openApi3MapperConfiguration,
		final SwaggerHubClient swaggerHubClient,
		final RecordBuilderFactory recordBuilderFactory) {

    	_tOpenApi3MapperConfiguration = openApi3MapperConfiguration;
        _swaggerHubClient = swaggerHubClient;
        _recordBuilderFactory = recordBuilderFactory;
    }

    @PostConstruct
    public void init() {
		OpenApi3Connection openApi3Connection =
			_tOpenApi3MapperConfiguration.getDataset().getDataStore();

		URL endpointInstanceURL = openApi3Connection.getEndpointInstanceUrl();

		_swaggerHubClient.base(endpointInstanceURL.toString());
	}

    @Assessor
    public long estimateSize() {
    	return 15L;
    }

    @Split
    public List<TOpenApi3Mapper> split(
    	@PartitionSize final long bundles) {

    	return singletonList(this);
    }

    @Emitter
    public TOpenApi3Source createWorker() {
        return new TOpenApi3Source(
        	_tOpenApi3MapperConfiguration.getDataset(), _swaggerHubClient, _recordBuilderFactory);
    }

	private final SwaggerHubClient _swaggerHubClient;
	private final TOpenApi3MapperConfiguration _tOpenApi3MapperConfiguration;
	private final RecordBuilderFactory _recordBuilderFactory;

}