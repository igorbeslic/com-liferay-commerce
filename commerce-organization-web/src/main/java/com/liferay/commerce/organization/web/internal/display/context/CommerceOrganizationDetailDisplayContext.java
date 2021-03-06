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

package com.liferay.commerce.organization.web.internal.display.context;

import com.liferay.commerce.organization.service.CommerceOrganizationService;
import com.liferay.commerce.organization.util.CommerceOrganizationHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.users.admin.configuration.UserFileUploadsConfiguration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marco Leo
 */
public class CommerceOrganizationDetailDisplayContext
	extends BaseCommerceOrganizationDisplayContext {

	public CommerceOrganizationDetailDisplayContext(
		CommerceOrganizationHelper commerceOrganizationHelper,
		CommerceOrganizationService commerceOrganizationService,
		HttpServletRequest httpServletRequest,
		OrganizationLocalService organizationLocalService, Portal portal,
		UserFileUploadsConfiguration userFileUploadsConfiguration) {

		super(
			commerceOrganizationHelper, commerceOrganizationService,
			httpServletRequest, portal);

		_organizationLocalService = organizationLocalService;
		_userFileUploadsConfiguration = userFileUploadsConfiguration;
	}

	public Address getOrganizationPrimaryAddress() throws PortalException {
		Organization organization = getCurrentOrganization();

		return commerceOrganizationService.getOrganizationPrimaryAddress(
			organization.getOrganizationId());
	}

	public EmailAddress getOrganizationPrimaryEmailAddress()
		throws PortalException {

		Organization organization = getCurrentOrganization();

		return commerceOrganizationService.getOrganizationPrimaryEmailAddress(
			organization.getOrganizationId());
	}

	public String[] getOrganizationTypes() {
		return _organizationLocalService.getTypes();
	}

	public UserFileUploadsConfiguration getUserFileUploadsConfiguration() {
		return _userFileUploadsConfiguration;
	}

	private final OrganizationLocalService _organizationLocalService;
	private final UserFileUploadsConfiguration _userFileUploadsConfiguration;

}