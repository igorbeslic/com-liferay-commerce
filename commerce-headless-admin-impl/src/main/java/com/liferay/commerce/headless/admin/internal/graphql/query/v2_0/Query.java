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

package com.liferay.commerce.headless.admin.internal.graphql.query.v2_0;

import com.liferay.commerce.headless.admin.dto.v2_0.Account;
import com.liferay.commerce.headless.admin.dto.v2_0.Address;
import com.liferay.commerce.headless.admin.dto.v2_0.Country;
import com.liferay.commerce.headless.admin.dto.v2_0.Currency;
import com.liferay.commerce.headless.admin.dto.v2_0.Inventory;
import com.liferay.commerce.headless.admin.dto.v2_0.Order;
import com.liferay.commerce.headless.admin.dto.v2_0.PriceEntry;
import com.liferay.commerce.headless.admin.dto.v2_0.PriceList;
import com.liferay.commerce.headless.admin.dto.v2_0.Product;
import com.liferay.commerce.headless.admin.dto.v2_0.ProductOption;
import com.liferay.commerce.headless.admin.dto.v2_0.ProductOptionValue;
import com.liferay.commerce.headless.admin.dto.v2_0.Region;
import com.liferay.commerce.headless.admin.dto.v2_0.Sku;
import com.liferay.commerce.headless.admin.dto.v2_0.User;
import com.liferay.commerce.headless.admin.dto.v2_0.WebSite;
import com.liferay.commerce.headless.admin.resource.v2_0.AccountResource;
import com.liferay.commerce.headless.admin.resource.v2_0.AddressResource;
import com.liferay.commerce.headless.admin.resource.v2_0.CountryResource;
import com.liferay.commerce.headless.admin.resource.v2_0.CurrencyResource;
import com.liferay.commerce.headless.admin.resource.v2_0.InventoryResource;
import com.liferay.commerce.headless.admin.resource.v2_0.OrderResource;
import com.liferay.commerce.headless.admin.resource.v2_0.PriceEntryResource;
import com.liferay.commerce.headless.admin.resource.v2_0.PriceListResource;
import com.liferay.commerce.headless.admin.resource.v2_0.ProductOptionResource;
import com.liferay.commerce.headless.admin.resource.v2_0.ProductOptionValueResource;
import com.liferay.commerce.headless.admin.resource.v2_0.ProductResource;
import com.liferay.commerce.headless.admin.resource.v2_0.RegionResource;
import com.liferay.commerce.headless.admin.resource.v2_0.SkuResource;
import com.liferay.commerce.headless.admin.resource.v2_0.UserResource;
import com.liferay.commerce.headless.admin.resource.v2_0.WebSiteResource;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Igor Beslic
 * @generated
 */
@Generated("")
public class Query {

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Account> getAccounts() throws Exception {
		AccountResource accountResource = _createAccountResource();

		Page paginationPage = accountResource.getAccounts();

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Account getAccount(@GraphQLName("id") Long id) throws Exception {
		AccountResource accountResource = _createAccountResource();

		return accountResource.getAccount(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Address> getAddresses(@GraphQLName("id") Long id)
		throws Exception {

		AccountResource accountResource = _createAccountResource();

		Page paginationPage = accountResource.getAddresses(id);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Order> getOrder(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId)
		throws Exception {

		AccountResource accountResource = _createAccountResource();

		Page paginationPage = accountResource.getOrder(id, groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Address getAddress(@GraphQLName("id") Long id) throws Exception {
		AddressResource addressResource = _createAddressResource();

		return addressResource.getAddress(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Country> getCountries(
			@GraphQLName("groupId") Long groupId)
		throws Exception {

		CountryResource countryResource = _createCountryResource();

		Page paginationPage = countryResource.getCountries(groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Country getCountry(@GraphQLName("id") Long id) throws Exception {
		CountryResource countryResource = _createCountryResource();

		return countryResource.getCountry(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Region> getRegions(@GraphQLName("id") Long id)
		throws Exception {

		CountryResource countryResource = _createCountryResource();

		Page paginationPage = countryResource.getRegions(id);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Currency> getCurrencies(
			@GraphQLName("groupId") Long groupId)
		throws Exception {

		CurrencyResource currencyResource = _createCurrencyResource();

		Page paginationPage = currencyResource.getCurrencies(groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Currency getCurrency(@GraphQLName("id") Long id) throws Exception {
		CurrencyResource currencyResource = _createCurrencyResource();

		return currencyResource.getCurrency(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Inventory getInventory(@GraphQLName("id") Long id) throws Exception {
		InventoryResource inventoryResource = _createInventoryResource();

		return inventoryResource.getInventory(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Order> getOrders(@GraphQLName("groupId") Long groupId)
		throws Exception {

		OrderResource orderResource = _createOrderResource();

		Page paginationPage = orderResource.getOrders(groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Order getOrder(@GraphQLName("id") Long id) throws Exception {
		OrderResource orderResource = _createOrderResource();

		return orderResource.getOrder(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Address getOrderAddress(@GraphQLName("id") Long id)
		throws Exception {

		OrderResource orderResource = _createOrderResource();

		return orderResource.getOrderAddress(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<PriceEntry> getPriceEntries(
			@GraphQLName("groupId") Long groupId)
		throws Exception {

		PriceEntryResource priceEntryResource = _createPriceEntryResource();

		Page paginationPage = priceEntryResource.getPriceEntries(groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public PriceEntry getPriceEntry(@GraphQLName("id") Long id)
		throws Exception {

		PriceEntryResource priceEntryResource = _createPriceEntryResource();

		return priceEntryResource.getPriceEntry(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<PriceList> getPriceLists(
			@GraphQLName("groupId") Long groupId)
		throws Exception {

		PriceListResource priceListResource = _createPriceListResource();

		Page paginationPage = priceListResource.getPriceLists(groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public PriceList getPriceList(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId)
		throws Exception {

		PriceListResource priceListResource = _createPriceListResource();

		return priceListResource.getPriceList(id, groupId);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Product> getProducts(@GraphQLName("groupId") Long groupId)
		throws Exception {

		ProductResource productResource = _createProductResource();

		Page paginationPage = productResource.getProducts(groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Product getProduct(@GraphQLName("id") Long id) throws Exception {
		ProductResource productResource = _createProductResource();

		return productResource.getProduct(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Sku> getSkus(@GraphQLName("id") Long id)
		throws Exception {

		ProductResource productResource = _createProductResource();

		Page paginationPage = productResource.getSkus(id);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<ProductOption> getProductOptions(
			@GraphQLName("groupId") Long groupId)
		throws Exception {

		ProductOptionResource productOptionResource =
			_createProductOptionResource();

		Page paginationPage = productOptionResource.getProductOptions(groupId);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ProductOption getProductOption(@GraphQLName("id") Long id)
		throws Exception {

		ProductOptionResource productOptionResource =
			_createProductOptionResource();

		return productOptionResource.getProductOption(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<ProductOptionValue> getProductOptionValues(
			@GraphQLName("id") Long id)
		throws Exception {

		ProductOptionValueResource productOptionValueResource =
			_createProductOptionValueResource();

		Page paginationPage = productOptionValueResource.getProductOptionValues(
			id);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ProductOptionValue getProductOptionValue(@GraphQLName("id") Long id)
		throws Exception {

		ProductOptionValueResource productOptionValueResource =
			_createProductOptionValueResource();

		return productOptionValueResource.getProductOptionValue(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Region getRegion(@GraphQLName("id") Long id) throws Exception {
		RegionResource regionResource = _createRegionResource();

		return regionResource.getRegion(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Sku getSku(@GraphQLName("id") Long id) throws Exception {
		SkuResource skuResource = _createSkuResource();

		return skuResource.getSku(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Inventory> getInventorys(@GraphQLName("id") Long id)
		throws Exception {

		SkuResource skuResource = _createSkuResource();

		Page paginationPage = skuResource.getInventorys(id);

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<User> getUsers() throws Exception {
		UserResource userResource = _createUserResource();

		Page paginationPage = userResource.getUsers();

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public User getUser(@GraphQLName("id") Long id) throws Exception {
		UserResource userResource = _createUserResource();

		return userResource.getUser(id);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<WebSite> getWebSites() throws Exception {
		WebSiteResource webSiteResource = _createWebSiteResource();

		Page paginationPage = webSiteResource.getWebSites();

		return paginationPage.getItems();
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public WebSite getWebSite(@GraphQLName("id") Long id) throws Exception {
		WebSiteResource webSiteResource = _createWebSiteResource();

		return webSiteResource.getWebSite(id);
	}

	private static AccountResource _createAccountResource() throws Exception {
		AccountResource accountResource =
			_accountResourceServiceTracker.getService();

		accountResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return accountResource;
	}

	private static final ServiceTracker<AccountResource, AccountResource>
		_accountResourceServiceTracker;

	private static AddressResource _createAddressResource() throws Exception {
		AddressResource addressResource =
			_addressResourceServiceTracker.getService();

		addressResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return addressResource;
	}

	private static final ServiceTracker<AddressResource, AddressResource>
		_addressResourceServiceTracker;

	private static CountryResource _createCountryResource() throws Exception {
		CountryResource countryResource =
			_countryResourceServiceTracker.getService();

		countryResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return countryResource;
	}

	private static final ServiceTracker<CountryResource, CountryResource>
		_countryResourceServiceTracker;

	private static CurrencyResource _createCurrencyResource() throws Exception {
		CurrencyResource currencyResource =
			_currencyResourceServiceTracker.getService();

		currencyResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return currencyResource;
	}

	private static final ServiceTracker<CurrencyResource, CurrencyResource>
		_currencyResourceServiceTracker;

	private static InventoryResource _createInventoryResource()
		throws Exception {

		InventoryResource inventoryResource =
			_inventoryResourceServiceTracker.getService();

		inventoryResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return inventoryResource;
	}

	private static final ServiceTracker<InventoryResource, InventoryResource>
		_inventoryResourceServiceTracker;

	private static OrderResource _createOrderResource() throws Exception {
		OrderResource orderResource = _orderResourceServiceTracker.getService();

		orderResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return orderResource;
	}

	private static final ServiceTracker<OrderResource, OrderResource>
		_orderResourceServiceTracker;

	private static PriceEntryResource _createPriceEntryResource()
		throws Exception {

		PriceEntryResource priceEntryResource =
			_priceEntryResourceServiceTracker.getService();

		priceEntryResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return priceEntryResource;
	}

	private static final ServiceTracker<PriceEntryResource, PriceEntryResource>
		_priceEntryResourceServiceTracker;

	private static PriceListResource _createPriceListResource()
		throws Exception {

		PriceListResource priceListResource =
			_priceListResourceServiceTracker.getService();

		priceListResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return priceListResource;
	}

	private static final ServiceTracker<PriceListResource, PriceListResource>
		_priceListResourceServiceTracker;

	private static ProductResource _createProductResource() throws Exception {
		ProductResource productResource =
			_productResourceServiceTracker.getService();

		productResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return productResource;
	}

	private static final ServiceTracker<ProductResource, ProductResource>
		_productResourceServiceTracker;

	private static ProductOptionResource _createProductOptionResource()
		throws Exception {

		ProductOptionResource productOptionResource =
			_productOptionResourceServiceTracker.getService();

		productOptionResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return productOptionResource;
	}

	private static final ServiceTracker
		<ProductOptionResource, ProductOptionResource>
			_productOptionResourceServiceTracker;

	private static ProductOptionValueResource
			_createProductOptionValueResource()
		throws Exception {

		ProductOptionValueResource productOptionValueResource =
			_productOptionValueResourceServiceTracker.getService();

		productOptionValueResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return productOptionValueResource;
	}

	private static final ServiceTracker
		<ProductOptionValueResource, ProductOptionValueResource>
			_productOptionValueResourceServiceTracker;

	private static RegionResource _createRegionResource() throws Exception {
		RegionResource regionResource =
			_regionResourceServiceTracker.getService();

		regionResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return regionResource;
	}

	private static final ServiceTracker<RegionResource, RegionResource>
		_regionResourceServiceTracker;

	private static SkuResource _createSkuResource() throws Exception {
		SkuResource skuResource = _skuResourceServiceTracker.getService();

		skuResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return skuResource;
	}

	private static final ServiceTracker<SkuResource, SkuResource>
		_skuResourceServiceTracker;

	private static UserResource _createUserResource() throws Exception {
		UserResource userResource = _userResourceServiceTracker.getService();

		userResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return userResource;
	}

	private static final ServiceTracker<UserResource, UserResource>
		_userResourceServiceTracker;

	private static WebSiteResource _createWebSiteResource() throws Exception {
		WebSiteResource webSiteResource =
			_webSiteResourceServiceTracker.getService();

		webSiteResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));

		return webSiteResource;
	}

	private static final ServiceTracker<WebSiteResource, WebSiteResource>
		_webSiteResourceServiceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(Query.class);

		ServiceTracker<AccountResource, AccountResource>
			accountResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), AccountResource.class, null);

		accountResourceServiceTracker.open();

		_accountResourceServiceTracker = accountResourceServiceTracker;
		ServiceTracker<AddressResource, AddressResource>
			addressResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), AddressResource.class, null);

		addressResourceServiceTracker.open();

		_addressResourceServiceTracker = addressResourceServiceTracker;
		ServiceTracker<CountryResource, CountryResource>
			countryResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), CountryResource.class, null);

		countryResourceServiceTracker.open();

		_countryResourceServiceTracker = countryResourceServiceTracker;
		ServiceTracker<CurrencyResource, CurrencyResource>
			currencyResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), CurrencyResource.class, null);

		currencyResourceServiceTracker.open();

		_currencyResourceServiceTracker = currencyResourceServiceTracker;
		ServiceTracker<InventoryResource, InventoryResource>
			inventoryResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), InventoryResource.class, null);

		inventoryResourceServiceTracker.open();

		_inventoryResourceServiceTracker = inventoryResourceServiceTracker;
		ServiceTracker<OrderResource, OrderResource>
			orderResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), OrderResource.class, null);

		orderResourceServiceTracker.open();

		_orderResourceServiceTracker = orderResourceServiceTracker;
		ServiceTracker<PriceEntryResource, PriceEntryResource>
			priceEntryResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), PriceEntryResource.class, null);

		priceEntryResourceServiceTracker.open();

		_priceEntryResourceServiceTracker = priceEntryResourceServiceTracker;
		ServiceTracker<PriceListResource, PriceListResource>
			priceListResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), PriceListResource.class, null);

		priceListResourceServiceTracker.open();

		_priceListResourceServiceTracker = priceListResourceServiceTracker;
		ServiceTracker<ProductResource, ProductResource>
			productResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), ProductResource.class, null);

		productResourceServiceTracker.open();

		_productResourceServiceTracker = productResourceServiceTracker;
		ServiceTracker<ProductOptionResource, ProductOptionResource>
			productOptionResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), ProductOptionResource.class, null);

		productOptionResourceServiceTracker.open();

		_productOptionResourceServiceTracker =
			productOptionResourceServiceTracker;
		ServiceTracker<ProductOptionValueResource, ProductOptionValueResource>
			productOptionValueResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), ProductOptionValueResource.class,
				null);

		productOptionValueResourceServiceTracker.open();

		_productOptionValueResourceServiceTracker =
			productOptionValueResourceServiceTracker;
		ServiceTracker<RegionResource, RegionResource>
			regionResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), RegionResource.class, null);

		regionResourceServiceTracker.open();

		_regionResourceServiceTracker = regionResourceServiceTracker;
		ServiceTracker<SkuResource, SkuResource> skuResourceServiceTracker =
			new ServiceTracker<>(
				bundle.getBundleContext(), SkuResource.class, null);

		skuResourceServiceTracker.open();

		_skuResourceServiceTracker = skuResourceServiceTracker;
		ServiceTracker<UserResource, UserResource> userResourceServiceTracker =
			new ServiceTracker<>(
				bundle.getBundleContext(), UserResource.class, null);

		userResourceServiceTracker.open();

		_userResourceServiceTracker = userResourceServiceTracker;
		ServiceTracker<WebSiteResource, WebSiteResource>
			webSiteResourceServiceTracker = new ServiceTracker<>(
				bundle.getBundleContext(), WebSiteResource.class, null);

		webSiteResourceServiceTracker.open();

		_webSiteResourceServiceTracker = webSiteResourceServiceTracker;
	}

}