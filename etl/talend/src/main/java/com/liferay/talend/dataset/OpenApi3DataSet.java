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

package com.liferay.talend.dataset;

import com.liferay.talend.datastore.OpenApi3Connection;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.action.Suggestable;
import org.talend.sdk.component.api.configuration.constraint.Required;
import org.talend.sdk.component.api.configuration.type.DataSet;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.meta.Documentation;

import java.io.Serializable;

/**
 * @author Igor Beslic
 */
@DataSet("OpenApi3DataSet")
@GridLayout({
    @GridLayout.Row({ "_openApi3Connection" }),
	@GridLayout.Row({ "targetModulePath" })
})
@Documentation("Additional Open Api 3 properties and directives needed for parser services")
public class OpenApi3DataSet implements Serializable {

    public OpenApi3Connection getDataStore() {
        return _openApi3Connection;
    }

    public OpenApi3DataSet setDataStore(OpenApi3Connection dataStore) {
        _openApi3Connection = dataStore;

        return this;
    }

	public String getTargetModulePath() {
		return _targetModulePath;
	}

	public OpenApi3DataSet setTargetModulePath(String targetModulePath) {
		_targetModulePath = targetModulePath;

		return this;
	}

	@Documentation("Connection configuration for Swagger Hub")
	@Option("_openApi3Connection")
	@Required
	private OpenApi3Connection _openApi3Connection;

	@Documentation("Path of particular module REST service")
	@Option("targetModulePath")
	@Suggestable(value = "OpenApi3Paths", parameters = {"_openApi3Connection"})
	private String _targetModulePath;

}