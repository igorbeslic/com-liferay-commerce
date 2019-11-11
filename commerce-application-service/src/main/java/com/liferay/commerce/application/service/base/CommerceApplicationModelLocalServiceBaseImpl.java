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

package com.liferay.commerce.application.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.application.model.CommerceApplicationModel;
import com.liferay.commerce.application.service.CommerceApplicationModelLocalService;
import com.liferay.commerce.application.service.persistence.CommerceApplicationBrandPersistence;
import com.liferay.commerce.application.service.persistence.CommerceApplicationModelCProductRelPersistence;
import com.liferay.commerce.application.service.persistence.CommerceApplicationModelPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce application model local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.application.service.impl.CommerceApplicationModelLocalServiceImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see com.liferay.commerce.application.service.impl.CommerceApplicationModelLocalServiceImpl
 * @see com.liferay.commerce.application.service.CommerceApplicationModelLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class CommerceApplicationModelLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CommerceApplicationModelLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.commerce.application.service.CommerceApplicationModelLocalServiceUtil} to access the commerce application model local service.
	 */

	/**
	 * Adds the commerce application model to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceApplicationModel the commerce application model
	 * @return the commerce application model that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceApplicationModel addCommerceApplicationModel(
		CommerceApplicationModel commerceApplicationModel) {
		commerceApplicationModel.setNew(true);

		return commerceApplicationModelPersistence.update(commerceApplicationModel);
	}

	/**
	 * Creates a new commerce application model with the primary key. Does not add the commerce application model to the database.
	 *
	 * @param commerceApplicationModelId the primary key for the new commerce application model
	 * @return the new commerce application model
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceApplicationModel createCommerceApplicationModel(
		long commerceApplicationModelId) {
		return commerceApplicationModelPersistence.create(commerceApplicationModelId);
	}

	/**
	 * Deletes the commerce application model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceApplicationModelId the primary key of the commerce application model
	 * @return the commerce application model that was removed
	 * @throws PortalException if a commerce application model with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceApplicationModel deleteCommerceApplicationModel(
		long commerceApplicationModelId) throws PortalException {
		return commerceApplicationModelPersistence.remove(commerceApplicationModelId);
	}

	/**
	 * Deletes the commerce application model from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceApplicationModel the commerce application model
	 * @return the commerce application model that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceApplicationModel deleteCommerceApplicationModel(
		CommerceApplicationModel commerceApplicationModel)
		throws PortalException {
		return commerceApplicationModelPersistence.remove(commerceApplicationModel);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CommerceApplicationModel.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceApplicationModelPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.application.model.impl.CommerceApplicationModelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return commerceApplicationModelPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.application.model.impl.CommerceApplicationModelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return commerceApplicationModelPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceApplicationModelPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return commerceApplicationModelPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CommerceApplicationModel fetchCommerceApplicationModel(
		long commerceApplicationModelId) {
		return commerceApplicationModelPersistence.fetchByPrimaryKey(commerceApplicationModelId);
	}

	/**
	 * Returns the commerce application model with the primary key.
	 *
	 * @param commerceApplicationModelId the primary key of the commerce application model
	 * @return the commerce application model
	 * @throws PortalException if a commerce application model with the primary key could not be found
	 */
	@Override
	public CommerceApplicationModel getCommerceApplicationModel(
		long commerceApplicationModelId) throws PortalException {
		return commerceApplicationModelPersistence.findByPrimaryKey(commerceApplicationModelId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(commerceApplicationModelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceApplicationModel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceApplicationModelId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(commerceApplicationModelLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CommerceApplicationModel.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceApplicationModelId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(commerceApplicationModelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceApplicationModel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceApplicationModelId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return commerceApplicationModelLocalService.deleteCommerceApplicationModel((CommerceApplicationModel)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return commerceApplicationModelPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce application models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.application.model.impl.CommerceApplicationModelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce application models
	 * @param end the upper bound of the range of commerce application models (not inclusive)
	 * @return the range of commerce application models
	 */
	@Override
	public List<CommerceApplicationModel> getCommerceApplicationModels(
		int start, int end) {
		return commerceApplicationModelPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce application models.
	 *
	 * @return the number of commerce application models
	 */
	@Override
	public int getCommerceApplicationModelsCount() {
		return commerceApplicationModelPersistence.countAll();
	}

	/**
	 * Updates the commerce application model in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commerceApplicationModel the commerce application model
	 * @return the commerce application model that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceApplicationModel updateCommerceApplicationModel(
		CommerceApplicationModel commerceApplicationModel) {
		return commerceApplicationModelPersistence.update(commerceApplicationModel);
	}

	/**
	 * Returns the commerce application brand local service.
	 *
	 * @return the commerce application brand local service
	 */
	public com.liferay.commerce.application.service.CommerceApplicationBrandLocalService getCommerceApplicationBrandLocalService() {
		return commerceApplicationBrandLocalService;
	}

	/**
	 * Sets the commerce application brand local service.
	 *
	 * @param commerceApplicationBrandLocalService the commerce application brand local service
	 */
	public void setCommerceApplicationBrandLocalService(
		com.liferay.commerce.application.service.CommerceApplicationBrandLocalService commerceApplicationBrandLocalService) {
		this.commerceApplicationBrandLocalService = commerceApplicationBrandLocalService;
	}

	/**
	 * Returns the commerce application brand persistence.
	 *
	 * @return the commerce application brand persistence
	 */
	public CommerceApplicationBrandPersistence getCommerceApplicationBrandPersistence() {
		return commerceApplicationBrandPersistence;
	}

	/**
	 * Sets the commerce application brand persistence.
	 *
	 * @param commerceApplicationBrandPersistence the commerce application brand persistence
	 */
	public void setCommerceApplicationBrandPersistence(
		CommerceApplicationBrandPersistence commerceApplicationBrandPersistence) {
		this.commerceApplicationBrandPersistence = commerceApplicationBrandPersistence;
	}

	/**
	 * Returns the commerce application model local service.
	 *
	 * @return the commerce application model local service
	 */
	public CommerceApplicationModelLocalService getCommerceApplicationModelLocalService() {
		return commerceApplicationModelLocalService;
	}

	/**
	 * Sets the commerce application model local service.
	 *
	 * @param commerceApplicationModelLocalService the commerce application model local service
	 */
	public void setCommerceApplicationModelLocalService(
		CommerceApplicationModelLocalService commerceApplicationModelLocalService) {
		this.commerceApplicationModelLocalService = commerceApplicationModelLocalService;
	}

	/**
	 * Returns the commerce application model persistence.
	 *
	 * @return the commerce application model persistence
	 */
	public CommerceApplicationModelPersistence getCommerceApplicationModelPersistence() {
		return commerceApplicationModelPersistence;
	}

	/**
	 * Sets the commerce application model persistence.
	 *
	 * @param commerceApplicationModelPersistence the commerce application model persistence
	 */
	public void setCommerceApplicationModelPersistence(
		CommerceApplicationModelPersistence commerceApplicationModelPersistence) {
		this.commerceApplicationModelPersistence = commerceApplicationModelPersistence;
	}

	/**
	 * Returns the commerce application model c product rel local service.
	 *
	 * @return the commerce application model c product rel local service
	 */
	public com.liferay.commerce.application.service.CommerceApplicationModelCProductRelLocalService getCommerceApplicationModelCProductRelLocalService() {
		return commerceApplicationModelCProductRelLocalService;
	}

	/**
	 * Sets the commerce application model c product rel local service.
	 *
	 * @param commerceApplicationModelCProductRelLocalService the commerce application model c product rel local service
	 */
	public void setCommerceApplicationModelCProductRelLocalService(
		com.liferay.commerce.application.service.CommerceApplicationModelCProductRelLocalService commerceApplicationModelCProductRelLocalService) {
		this.commerceApplicationModelCProductRelLocalService = commerceApplicationModelCProductRelLocalService;
	}

	/**
	 * Returns the commerce application model c product rel persistence.
	 *
	 * @return the commerce application model c product rel persistence
	 */
	public CommerceApplicationModelCProductRelPersistence getCommerceApplicationModelCProductRelPersistence() {
		return commerceApplicationModelCProductRelPersistence;
	}

	/**
	 * Sets the commerce application model c product rel persistence.
	 *
	 * @param commerceApplicationModelCProductRelPersistence the commerce application model c product rel persistence
	 */
	public void setCommerceApplicationModelCProductRelPersistence(
		CommerceApplicationModelCProductRelPersistence commerceApplicationModelCProductRelPersistence) {
		this.commerceApplicationModelCProductRelPersistence = commerceApplicationModelCProductRelPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.commerce.application.model.CommerceApplicationModel",
			commerceApplicationModelLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.application.model.CommerceApplicationModel");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceApplicationModelLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceApplicationModel.class;
	}

	protected String getModelClassName() {
		return CommerceApplicationModel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = commerceApplicationModelPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.commerce.application.service.CommerceApplicationBrandLocalService.class)
	protected com.liferay.commerce.application.service.CommerceApplicationBrandLocalService commerceApplicationBrandLocalService;
	@BeanReference(type = CommerceApplicationBrandPersistence.class)
	protected CommerceApplicationBrandPersistence commerceApplicationBrandPersistence;
	@BeanReference(type = CommerceApplicationModelLocalService.class)
	protected CommerceApplicationModelLocalService commerceApplicationModelLocalService;
	@BeanReference(type = CommerceApplicationModelPersistence.class)
	protected CommerceApplicationModelPersistence commerceApplicationModelPersistence;
	@BeanReference(type = com.liferay.commerce.application.service.CommerceApplicationModelCProductRelLocalService.class)
	protected com.liferay.commerce.application.service.CommerceApplicationModelCProductRelLocalService commerceApplicationModelCProductRelLocalService;
	@BeanReference(type = CommerceApplicationModelCProductRelPersistence.class)
	protected CommerceApplicationModelCProductRelPersistence commerceApplicationModelCProductRelPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}