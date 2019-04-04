package com.liferay.talend.configuration;

import com.liferay.talend.dataset.DefaultDataSet;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.meta.Documentation;

import java.io.Serializable;

@Documentation("Configuration stub that satisfies Talend component configuration requirements")
@GridLayout({
	@GridLayout.Row({ "_defaultDataSet" })
})
public class DefaultComponentConfiguration implements Serializable {

	public DefaultDataSet getDefaultDataSet() {
		return _defaultDataSet;
	}

	public DefaultComponentConfiguration setDefaultDataSet(
		DefaultDataSet defaultDataSet) {

		_defaultDataSet = defaultDataSet;

		return this;
	}

	@Option("_defaultDataSet")
	@Documentation("DataSet stub implementation that holds no data.")
	private DefaultDataSet _defaultDataSet;

}
