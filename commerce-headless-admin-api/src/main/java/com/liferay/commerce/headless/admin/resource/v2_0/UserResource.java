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

package com.liferay.commerce.headless.admin.resource.v2_0;

import com.liferay.commerce.headless.admin.dto.v2_0.Error;
import com.liferay.commerce.headless.admin.dto.v2_0.User;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.pagination.Page;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/commerce-headless-admin/v2.0
 *
 * @author Igor Beslic
 * @generated
 */
@Generated("")
public interface UserResource {

	public Page<User> getUsers() throws Exception;

	public User upsertUser(User user) throws Exception;

	public Error deleteUser(Long id) throws Exception;

	public User getUser(Long id) throws Exception;

	public Error updateUser(Long id, User user) throws Exception;

	public void setContextCompany(Company contextCompany);

}