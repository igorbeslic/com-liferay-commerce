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

import com.liferay.talend.dataset.OpenApi3DataSet;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.meta.Documentation;

import java.io.Serializable;

/**
 * @author Igor Beslic
 */
@GridLayout({
    @GridLayout.Row({ "_openApi3DataSet" })
})
@Documentation("TODO fill the documentation for this configuration")
public class TOpenApi3MapperConfiguration implements Serializable {
    @Option("_openApi3DataSet")
    @Documentation("TODO fill the documentation for this parameter")
    private OpenApi3DataSet _openApi3DataSet;

    public OpenApi3DataSet getDataset() {
        return _openApi3DataSet;
    }

    public TOpenApi3MapperConfiguration setOpenApi3DataSet(OpenApi3DataSet openApi3DataSet) {
        _openApi3DataSet = openApi3DataSet;

        return this;
    }

}