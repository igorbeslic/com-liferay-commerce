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

package com.liferay.commerce.headless.admin.internal.graphql.mutation.v2_0;

import com.liferay.commerce.headless.admin.dto.v2_0.Account;
import com.liferay.commerce.headless.admin.dto.v2_0.Address;
import com.liferay.commerce.headless.admin.dto.v2_0.Country;
import com.liferay.commerce.headless.admin.dto.v2_0.Currency;
import com.liferay.commerce.headless.admin.dto.v2_0.Error;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Igor Beslic
 * @generated
 */
@Generated("")
public class Mutation {

	@GraphQLField
	@GraphQLInvokeDetached
	public Account upsertAccount(@GraphQLName("Account") Account account)
		throws Exception {

		AccountResource accountResource = _createAccountResource();

		return accountResource.upsertAccount(account);
	}

	@GraphQLInvokeDetached
	public Error deleteAccount(@GraphQLName("id") Long id) throws Exception {
		AccountResource accountResource = _createAccountResource();

		return accountResource.deleteAccount(id);
	}

	@GraphQLInvokeDetached
	public Error updateAccount(
			@GraphQLName("id") Long id, @GraphQLName("Account") Account account)
		throws Exception {

		AccountResource accountResource = _createAccountResource();

		return accountResource.updateAccount(id, account);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Address upsertAccountAddress(
			@GraphQLName("id") Long id, @GraphQLName("Address") Address address)
		throws Exception {

		AccountResource accountResource = _createAccountResource();

		return accountResource.upsertAccountAddress(id, address);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Order upsertSku(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Order") Order order)
		throws Exception {

		AccountResource accountResource = _createAccountResource();

		return accountResource.upsertSku(id, groupId, order);
	}

	@GraphQLInvokeDetached
	public Error deleteAddress(@GraphQLName("id") Long id) throws Exception {
		AddressResource addressResource = _createAddressResource();

		return addressResource.deleteAddress(id);
	}

	@GraphQLInvokeDetached
	public Error updateAddress(
			@GraphQLName("id") Long id, @GraphQLName("Address") Address address)
		throws Exception {

		AddressResource addressResource = _createAddressResource();

		return addressResource.updateAddress(id, address);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Country upsertCountry(
			@GraphQLName("groupId") Long groupId,
			@GraphQLName("Country") Country country)
		throws Exception {

		CountryResource countryResource = _createCountryResource();

		return countryResource.upsertCountry(groupId, country);
	}

	@GraphQLInvokeDetached
	public Error deleteCountry(@GraphQLName("id") Long id) throws Exception {
		CountryResource countryResource = _createCountryResource();

		return countryResource.deleteCountry(id);
	}

	@GraphQLInvokeDetached
	public Error updateCountry(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Country") Country country)
		throws Exception {

		CountryResource countryResource = _createCountryResource();

		return countryResource.updateCountry(id, groupId, country);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Region upsertRegion(
			@GraphQLName("id") Long id, @GraphQLName("Region") Region region)
		throws Exception {

		CountryResource countryResource = _createCountryResource();

		return countryResource.upsertRegion(id, region);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Currency upsertCurrency(
			@GraphQLName("groupId") Long groupId,
			@GraphQLName("Currency") Currency currency)
		throws Exception {

		CurrencyResource currencyResource = _createCurrencyResource();

		return currencyResource.upsertCurrency(groupId, currency);
	}

	@GraphQLInvokeDetached
	public Error deleteCurrency(@GraphQLName("id") Long id) throws Exception {
		CurrencyResource currencyResource = _createCurrencyResource();

		return currencyResource.deleteCurrency(id);
	}

	@GraphQLInvokeDetached
	public Error updateCurrency(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Currency") Currency currency)
		throws Exception {

		CurrencyResource currencyResource = _createCurrencyResource();

		return currencyResource.updateCurrency(id, groupId, currency);
	}

	@GraphQLInvokeDetached
	public Error deleteInventory(@GraphQLName("id") Long id) throws Exception {
		InventoryResource inventoryResource = _createInventoryResource();

		return inventoryResource.deleteInventory(id);
	}

	@GraphQLInvokeDetached
	public Error updateInventory(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Inventory") Inventory inventory)
		throws Exception {

		InventoryResource inventoryResource = _createInventoryResource();

		return inventoryResource.updateInventory(id, groupId, inventory);
	}

	@GraphQLInvokeDetached
	public Error deleteOrder(@GraphQLName("id") Long id) throws Exception {
		OrderResource orderResource = _createOrderResource();

		return orderResource.deleteOrder(id);
	}

	@GraphQLInvokeDetached
	public Error updateOrder(
			@GraphQLName("id") Long id, @GraphQLName("Order") Order order)
		throws Exception {

		OrderResource orderResource = _createOrderResource();

		return orderResource.updateOrder(id, order);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Address upsertOrderAddress(
			@GraphQLName("id") Long id, @GraphQLName("Address") Address address)
		throws Exception {

		OrderResource orderResource = _createOrderResource();

		return orderResource.upsertOrderAddress(id, address);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public PriceEntry upsertPriceEntry(
			@GraphQLName("groupId") Long groupId,
			@GraphQLName("PriceEntry") PriceEntry priceEntry)
		throws Exception {

		PriceEntryResource priceEntryResource = _createPriceEntryResource();

		return priceEntryResource.upsertPriceEntry(groupId, priceEntry);
	}

	@GraphQLInvokeDetached
	public Error deletePriceEntry(@GraphQLName("id") Long id) throws Exception {
		PriceEntryResource priceEntryResource = _createPriceEntryResource();

		return priceEntryResource.deletePriceEntry(id);
	}

	@GraphQLInvokeDetached
	public Error updatePriceEntry(
			@GraphQLName("id") Long id,
			@GraphQLName("PriceEntry") PriceEntry priceEntry)
		throws Exception {

		PriceEntryResource priceEntryResource = _createPriceEntryResource();

		return priceEntryResource.updatePriceEntry(id, priceEntry);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public PriceList upsertPriceList(
			@GraphQLName("groupId") Long groupId,
			@GraphQLName("PriceList") PriceList priceList)
		throws Exception {

		PriceListResource priceListResource = _createPriceListResource();

		return priceListResource.upsertPriceList(groupId, priceList);
	}

	@GraphQLInvokeDetached
	public Error deletePriceList(@GraphQLName("id") Long id) throws Exception {
		PriceListResource priceListResource = _createPriceListResource();

		return priceListResource.deletePriceList(id);
	}

	@GraphQLInvokeDetached
	public Error updatePriceList(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("PriceList") PriceList priceList)
		throws Exception {

		PriceListResource priceListResource = _createPriceListResource();

		return priceListResource.updatePriceList(id, groupId, priceList);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Product upsertProduct(
			@GraphQLName("groupId") Long groupId,
			@GraphQLName("Product") Product product)
		throws Exception {

		ProductResource productResource = _createProductResource();

		return productResource.upsertProduct(groupId, product);
	}

	@GraphQLInvokeDetached
	public Error deleteProduct(@GraphQLName("id") Long id) throws Exception {
		ProductResource productResource = _createProductResource();

		return productResource.deleteProduct(id);
	}

	@GraphQLInvokeDetached
	public Error updateProduct(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Product") Product product)
		throws Exception {

		ProductResource productResource = _createProductResource();

		return productResource.updateProduct(id, groupId, product);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Sku upsertSku(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Sku") Sku sku)
		throws Exception {

		ProductResource productResource = _createProductResource();

		return productResource.upsertSku(id, groupId, sku);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ProductOption upsertProductOption(
			@GraphQLName("groupId") Long groupId,
			@GraphQLName("ProductOption") ProductOption productOption)
		throws Exception {

		ProductOptionResource productOptionResource =
			_createProductOptionResource();

		return productOptionResource.upsertProductOption(
			groupId, productOption);
	}

	@GraphQLInvokeDetached
	public Error deleteProductOption(@GraphQLName("id") Long id)
		throws Exception {

		ProductOptionResource productOptionResource =
			_createProductOptionResource();

		return productOptionResource.deleteProductOption(id);
	}

	@GraphQLInvokeDetached
	public Error updateProductOption(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("ProductOption") ProductOption productOption)
		throws Exception {

		ProductOptionResource productOptionResource =
			_createProductOptionResource();

		return productOptionResource.updateProductOption(
			id, groupId, productOption);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public ProductOptionValue upsertProductOptionValue(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("ProductOptionValue") ProductOptionValue
				productOptionValue)
		throws Exception {

		ProductOptionValueResource productOptionValueResource =
			_createProductOptionValueResource();

		return productOptionValueResource.upsertProductOptionValue(
			id, groupId, productOptionValue);
	}

	@GraphQLInvokeDetached
	public Error deleteProductOptionValue(@GraphQLName("id") Long id)
		throws Exception {

		ProductOptionValueResource productOptionValueResource =
			_createProductOptionValueResource();

		return productOptionValueResource.deleteProductOptionValue(id);
	}

	@GraphQLInvokeDetached
	public Error updateProductOptionValue(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("ProductOptionValue") ProductOptionValue
				productOptionValue)
		throws Exception {

		ProductOptionValueResource productOptionValueResource =
			_createProductOptionValueResource();

		return productOptionValueResource.updateProductOptionValue(
			id, groupId, productOptionValue);
	}

	@GraphQLInvokeDetached
	public Error deleteRegion(@GraphQLName("id") Long id) throws Exception {
		RegionResource regionResource = _createRegionResource();

		return regionResource.deleteRegion(id);
	}

	@GraphQLInvokeDetached
	public Error updateRegion(
			@GraphQLName("id") Long id, @GraphQLName("Region") Region region)
		throws Exception {

		RegionResource regionResource = _createRegionResource();

		return regionResource.updateRegion(id, region);
	}

	@GraphQLInvokeDetached
	public Error deleteSku(@GraphQLName("id") Long id) throws Exception {
		SkuResource skuResource = _createSkuResource();

		return skuResource.deleteSku(id);
	}

	@GraphQLInvokeDetached
	public Error updateSku(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Sku") Sku sku)
		throws Exception {

		SkuResource skuResource = _createSkuResource();

		return skuResource.updateSku(id, groupId, sku);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Inventory upsertInventory(
			@GraphQLName("id") Long id, @GraphQLName("groupId") Long groupId,
			@GraphQLName("Inventory") Inventory inventory)
		throws Exception {

		SkuResource skuResource = _createSkuResource();

		return skuResource.upsertInventory(id, groupId, inventory);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public User upsertUser(@GraphQLName("User") User user) throws Exception {
		UserResource userResource = _createUserResource();

		return userResource.upsertUser(user);
	}

	@GraphQLInvokeDetached
	public Error deleteUser(@GraphQLName("id") Long id) throws Exception {
		UserResource userResource = _createUserResource();

		return userResource.deleteUser(id);
	}

	@GraphQLInvokeDetached
	public Error updateUser(
			@GraphQLName("id") Long id, @GraphQLName("User") User user)
		throws Exception {

		UserResource userResource = _createUserResource();

		return userResource.updateUser(id, user);
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

	static {
		Bundle bundle = FrameworkUtil.getBundle(Mutation.class);

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
	}

}