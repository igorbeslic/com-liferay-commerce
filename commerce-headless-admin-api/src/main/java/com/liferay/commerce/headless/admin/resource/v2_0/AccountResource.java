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

import com.liferay.commerce.headless.admin.dto.v2_0.Account;
import com.liferay.commerce.headless.admin.dto.v2_0.Address;
import com.liferay.commerce.headless.admin.dto.v2_0.Error;
import com.liferay.commerce.headless.admin.dto.v2_0.Order;
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
public interface AccountResource {

	public Page<Account> getAccounts() throws Exception;

	public Account upsertAccount(Account account) throws Exception;

	public Error deleteAccount(Long id) throws Exception;

	public Account getAccount(Long id) throws Exception;

	public Error updateAccount(Long id, Account account) throws Exception;

	public Page<Address> getAddresses(Long id) throws Exception;

	public Address upsertAccountAddress(Long id, Address address)
		throws Exception;

	public Page<Order> getOrder(Long id, Long groupId) throws Exception;

	public Order upsertSku(Long id, Long groupId, Order order) throws Exception;

	public void setContextCompany(Company contextCompany);

}