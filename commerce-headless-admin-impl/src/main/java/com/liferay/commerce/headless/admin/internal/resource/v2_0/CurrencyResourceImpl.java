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

package com.liferay.commerce.headless.admin.internal.resource.v2_0;

import com.liferay.commerce.headless.admin.resource.v2_0.CurrencyResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Igor Beslic
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/Currency.properties",
	scope = ServiceScope.PROTOTYPE, service = CurrencyResource.class
)
public class CurrencyResourceImpl extends BaseCurrencyResourceImpl {
}