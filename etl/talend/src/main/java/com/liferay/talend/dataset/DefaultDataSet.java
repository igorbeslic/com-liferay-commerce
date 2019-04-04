package com.liferay.talend.dataset;

import com.liferay.talend.datastore.DefaultDataStore;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.type.DataSet;
import org.talend.sdk.component.api.meta.Documentation;

@DataSet("DefaultDataSet")
@Documentation("DataSet stub that satisfies Talend component configuration requirements")
public class DefaultDataSet {

	public DefaultDataStore getDefaultDataStore() {
		return _defaultDataStore;
	}

	public DefaultDataSet setDefaultDataStore(DefaultDataStore defaultDataStore) {
		_defaultDataStore = defaultDataStore;

		return this;
	}

	@Option
	private DefaultDataStore _defaultDataStore;

}
