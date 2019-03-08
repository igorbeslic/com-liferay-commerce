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

import com.liferay.commerce.headless.admin.dto.v2_0.Error;
import com.liferay.commerce.headless.admin.dto.v2_0.PriceList;
import com.liferay.commerce.headless.admin.resource.v2_0.PriceListResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.net.URI;

import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 * @author Igor Beslic
 * @generated
 */
@Generated("")
@Path("/v2.0")
public abstract class BasePriceListResourceImpl implements PriceListResource {

	@Override
	@GET
	@Path("/priceList/")
	@Produces(
		{
			"application/*", "application/json", "application/json",
			"application/json"
		}
	)
	@Tags(value = {@Tag(name = "PriceList")})
	public Page<PriceList> getPriceLists(@QueryParam("groupId") Long groupId)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes("application/*")
	@POST
	@Path("/priceList/")
	@Produces(
		{
			"application/*", "application/json", "application/json",
			"application/json"
		}
	)
	@Tags(value = {@Tag(name = "PriceList")})
	public PriceList upsertPriceList(
			@QueryParam("groupId") Long groupId, PriceList priceList)
		throws Exception {

		return new PriceList();
	}

	@Override
	@DELETE
	@Path("/priceList/{id}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "PriceList")})
	public Error deletePriceList(@PathParam("id") Long id) throws Exception {
		return new Error();
	}

	@Override
	@GET
	@Path("/priceList/{id}")
	@Produces(
		{
			"application/*", "application/json", "application/json",
			"application/json"
		}
	)
	@Tags(value = {@Tag(name = "PriceList")})
	public PriceList getPriceList(
			@PathParam("id") Long id, @QueryParam("groupId") Long groupId)
		throws Exception {

		return new PriceList();
	}

	@Override
	@Consumes("application/*")
	@PUT
	@Path("/priceList/{id}")
	@Produces({"application/json", "application/json", "application/json"})
	@Tags(value = {@Tag(name = "PriceList")})
	public Error updatePriceList(
			@PathParam("id") Long id, @QueryParam("groupId") Long groupId,
			PriceList priceList)
		throws Exception {

		return new Error();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected String getJAXRSLink(String methodName, Object... values) {
		String baseURIString = String.valueOf(contextUriInfo.getBaseUri());

		if (baseURIString.endsWith(StringPool.FORWARD_SLASH)) {
			baseURIString = baseURIString.substring(
				0, baseURIString.length() - 1);
		}

		URI resourceURI = UriBuilder.fromResource(
			BasePriceListResourceImpl.class
		).build();

		URI methodURI = UriBuilder.fromMethod(
			BasePriceListResourceImpl.class, methodName
		).build(
			values
		);

		return baseURIString + resourceURI.toString() + methodURI.toString();
	}

	protected void preparePatch(PriceList priceList) {
	}

	protected <T, R> List<R> transform(
		List<T> list, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(list, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		List<T> list, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transformToArray(list, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}