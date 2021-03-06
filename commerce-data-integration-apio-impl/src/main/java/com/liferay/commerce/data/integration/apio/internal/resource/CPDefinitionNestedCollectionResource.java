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

package com.liferay.commerce.data.integration.apio.internal.resource;

import static com.liferay.commerce.data.integration.headless.compat.apio.idempotent.Idempotent.idempotent;

import com.liferay.apio.architect.pagination.PageItems;
import com.liferay.apio.architect.pagination.Pagination;
import com.liferay.apio.architect.representor.Representor;
import com.liferay.apio.architect.resource.NestedCollectionResource;
import com.liferay.apio.architect.routes.ItemRoutes;
import com.liferay.apio.architect.routes.NestedCollectionRoutes;
import com.liferay.commerce.data.integration.apio.identifier.CPDefinitionIdentifier;
import com.liferay.commerce.data.integration.apio.identifier.ClassPKExternalReferenceCode;
import com.liferay.commerce.data.integration.apio.internal.form.CPDefinitionUpserterForm;
import com.liferay.commerce.data.integration.apio.internal.util.CPDefinitionHelper;
import com.liferay.commerce.data.integration.headless.compat.apio.identifier.CommerceUserIdentifier;
import com.liferay.commerce.data.integration.headless.compat.apio.identifier.CommerceWebSiteIdentifier;
import com.liferay.commerce.data.integration.headless.compat.apio.permission.HasPermission;
import com.liferay.commerce.data.integration.headless.compat.apio.user.CurrentUser;
import com.liferay.commerce.data.integration.headless.compat.apio.util.UserHelper;
import com.liferay.commerce.product.exception.CPDefinitionProductTypeNameException;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionService;
import com.liferay.commerce.product.service.CPInstanceLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the information necessary to expose <a
 * href="http://schema.org/Product">Product</a> resources through a web API. The
 * resources are mapped from the internal model {@code CPDefinition}.
 *
 * @author Zoltán Takács
 */
@Component(immediate = true, service = NestedCollectionResource.class)
public class CPDefinitionNestedCollectionResource
	implements NestedCollectionResource
		<CPDefinition, ClassPKExternalReferenceCode, CPDefinitionIdentifier,
		 Long, CommerceWebSiteIdentifier> {

	@Override
	public NestedCollectionRoutes
		<CPDefinition, ClassPKExternalReferenceCode, Long> collectionRoutes(
			NestedCollectionRoutes.Builder
				<CPDefinition, ClassPKExternalReferenceCode, Long>
					builder) {

		return builder.addGetter(
			this::_getPageItems
		).addCreator(
			this::_upsertCPDefinition, CurrentUser.class,
			_hasPermission.forAddingIn(CommerceWebSiteIdentifier.class),
			CPDefinitionUpserterForm::buildForm
		).build();
	}

	@Override
	public String getName() {
		return "commerce-product-definition";
	}

	@Override
	public ItemRoutes<CPDefinition, ClassPKExternalReferenceCode> itemRoutes(
		ItemRoutes.Builder<CPDefinition, ClassPKExternalReferenceCode>
			builder) {

		return builder.addGetter(
			_cpDefinitionHelper::getCPDefinitionByClassPKExternalReferenceCode
		).addRemover(
			idempotent(_cpDefinitionHelper::deleteCPDefinition),
			_hasPermission::forDeleting
		).addUpdater(
			this::_updateCPDefinition, CurrentUser.class,
			_hasPermission::forUpdating, CPDefinitionUpserterForm::buildForm
		).build();
	}

	@Override
	public Representor<CPDefinition> representor(
		Representor.Builder<CPDefinition, ClassPKExternalReferenceCode>
			builder) {

		return builder.types(
			"CommerceProductDefinition"
		).identifier(
			_cpDefinitionHelper::cpDefinitionToClassPKExternalReferenceCode
		).addBidirectionalModel(
			"commerceWebSite", "commerceProductDefinitions",
			CommerceWebSiteIdentifier.class, CPDefinition::getGroupId
		).addDate(
			"dateCreated", CPDefinition::getCreateDate
		).addDate(
			"dateModified", CPDefinition::getModifiedDate
		).addLinkedModel(
			"author", CommerceUserIdentifier.class,
			cpDefinition -> _userHelper.userIdToClassPKExternalReferenceCode(
				cpDefinition.getUserId())
		).addString(
			"description", CPDefinition::getDescription
		).addString(
			"externalReferenceCode", CPDefinition::getExternalReferenceCode
		).addString(
			"productType", CPDefinition::getProductTypeName
		).addStringList(
			"skus", this::_getSKUs
		).addString(
			"title", CPDefinition::getName
		).build();
	}

	private PageItems<CPDefinition> _getPageItems(
			Pagination pagination, Long webSiteId)
		throws PortalException {

		List<CPDefinition> cpDefinitions =
			_cpDefinitionService.getCPDefinitions(
				webSiteId, null, null, WorkflowConstants.STATUS_APPROVED,
				pagination.getStartPosition(), pagination.getEndPosition(),
				null);

		int total = _cpDefinitionService.getCPDefinitionsCount(
			webSiteId, null, null, WorkflowConstants.STATUS_APPROVED);

		return new PageItems<>(cpDefinitions, total);
	}

	private List<String> _getSKUs(CPDefinition cpDefinition) {
		return Arrays.asList(
			_cpInstanceLocalService.getSKUs(cpDefinition.getCPDefinitionId()));
	}

	private CPDefinition _updateCPDefinition(
			ClassPKExternalReferenceCode cpDefinitionCPKERC,
			CPDefinitionUpserterForm cpDefinitionUpserterForm,
			CurrentUser currentUser)
		throws PortalException {

		return _cpDefinitionHelper.updateCPDefinition(
			cpDefinitionCPKERC, cpDefinitionUpserterForm.getTitleMap(),
			cpDefinitionUpserterForm.getDescriptionMap(),
			cpDefinitionUpserterForm.getShortDescriptionMap(),
			ArrayUtil.toLongArray(
				cpDefinitionUpserterForm.getAssetCategoryIds()),
			cpDefinitionUpserterForm.getExternalReferenceCode(),
			cpDefinitionUpserterForm.getActive(), currentUser);
	}

	private CPDefinition _upsertCPDefinition(
			Long webSiteId, CPDefinitionUpserterForm cpDefinitionUpserterForm,
			CurrentUser currentUser)
		throws PortalException {

		try {
			return _cpDefinitionHelper.upsertCPDefinition(
				webSiteId, cpDefinitionUpserterForm.getTitleMap(),
				cpDefinitionUpserterForm.getDescriptionMap(),
				cpDefinitionUpserterForm.getShortDescriptionMap(),
				cpDefinitionUpserterForm.getProductTypeName(),
				ArrayUtil.toLongArray(
					cpDefinitionUpserterForm.getAssetCategoryIds()),
				cpDefinitionUpserterForm.getExternalReferenceCode(),
				cpDefinitionUpserterForm.getDefaultSku(),
				cpDefinitionUpserterForm.getActive(), 0, currentUser);
		}
		catch (CPDefinitionProductTypeNameException cpdptne) {
			throw new NotFoundException(
				"Product type is not available: " +
					cpDefinitionUpserterForm.getProductTypeName(),
				cpdptne);
		}
	}

	@Reference
	private CPDefinitionHelper _cpDefinitionHelper;

	@Reference
	private CPDefinitionService _cpDefinitionService;

	@Reference
	private CPInstanceLocalService _cpInstanceLocalService;

	@Reference(
		target = "(model.class.name=com.liferay.commerce.product.model.CPDefinition)"
	)
	private HasPermission<ClassPKExternalReferenceCode> _hasPermission;

	@Reference
	private UserHelper _userHelper;

}