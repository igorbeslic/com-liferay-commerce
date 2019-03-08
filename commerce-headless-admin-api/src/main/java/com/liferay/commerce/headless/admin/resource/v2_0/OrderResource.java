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
public interface OrderResource {

	public Page<Order> getOrders(Long groupId) throws Exception;

	public Error deleteOrder(Long id) throws Exception;

	public Order getOrder(Long id) throws Exception;

	public Error updateOrder(Long id, Order order) throws Exception;

	public Address getOrderAddress(Long id) throws Exception;

	public Address upsertOrderAddress(Long id, Address address)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}