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

@Documentation("Gets OpenApi Specification JSON")
@Icon(value = Icon.IconType.STAR)
@PartitionMapper(name = "tOpenApi3Mapper")
@Version(1)
public class TOpenApi3Mapper implements Serializable {

    public TOpenApi3Mapper(
		@Option("configuration") final OpenApi3DataSet openApi3DataSet,
		final SwaggerHubClient swaggerHubClient,
		final RecordBuilderFactory recordBuilderFactory) {

    	_openApi3DataSet = openApi3DataSet;
        _swaggerHubClient = swaggerHubClient;
        _recordBuilderFactory = recordBuilderFactory;
    }

    @PostConstruct
    public void init() {
		OpenApi3Connection openApi3Connection =
			_openApi3DataSet.getDataStore();

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
        	_openApi3DataSet, _swaggerHubClient, _recordBuilderFactory);
    }

	private final SwaggerHubClient _swaggerHubClient;
	private final OpenApi3DataSet _openApi3DataSet;
	private final RecordBuilderFactory _recordBuilderFactory;

}