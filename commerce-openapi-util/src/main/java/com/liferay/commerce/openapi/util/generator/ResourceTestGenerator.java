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

package com.liferay.commerce.openapi.util.generator;

import com.liferay.commerce.openapi.util.Content;
import com.liferay.commerce.openapi.util.Method;
import com.liferay.commerce.openapi.util.OpenApi;
import com.liferay.commerce.openapi.util.OpenApiComponent;
import com.liferay.commerce.openapi.util.OpenApiProperty;
import com.liferay.commerce.openapi.util.Parameter;
import com.liferay.commerce.openapi.util.Path;
import com.liferay.commerce.openapi.util.Response;
import com.liferay.commerce.openapi.util.Schema;
import com.liferay.commerce.openapi.util.util.OpenApiComponentUtil;
import com.liferay.commerce.openapi.util.util.PackageUtils;
import com.liferay.commerce.openapi.util.util.Provider;
import com.liferay.commerce.openapi.util.util.StringUtils;

import java.io.IOException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Igor Beslic
 */
public class ResourceTestGenerator extends BaseSourceGenerator {

	public ResourceTestGenerator(
		String applicationBase, String author, String moduleOutputPath,
		boolean overwriteImplementation, String resourcePackagePath,
		OpenApi openApi) {

		String versionPackage = PackageUtils.toPackageName(
			openApi.getVersion());

		_applicationBasePath =
			"http://localhost:8080/o" + applicationBase + "/" + versionPackage +
				"/";

		_author = author;
		_moduleOutputPath = moduleOutputPath;
		_overwriteImplementation = overwriteImplementation;

		StringBuilder sb = new StringBuilder();

		sb.append(resourcePackagePath);
		sb.append(".");
		sb.append(versionPackage);
		sb.append(".test");

		_resourceTestPackagePath = sb.toString();

		_openApi = openApi;
	}

	public Method getCompatibleHttpPostMethod(
		String returnType, String mimeType, List<Method> methods,
		Set<OpenApiComponent> openApiComponents) {

		for (Method method : methods) {
			if (!method.isHttpPostMethod()) {
				continue;
			}

			Content requestBodyContent = method.getRequestBodyContent(mimeType);

			if (requestBodyContent == null) {
				continue;
			}

			Schema schema = requestBodyContent.getSchema();

			if (schema == null) {
				continue;
			}

			OpenApiComponent openApiComponent =
				OpenApiComponentUtil.getOpenApiComponent(
					schema.getReference(), openApiComponents);

			if (returnType.equals(openApiComponent.getName())) {
				return method;
			}
		}

		return null;
	}

	public String getGetResourceDTOMethod(OpenApiComponent openApiComponent)
		throws IOException {

		String methodTemplate = getTemplate("test/test.get.DTO.method.tpl");

		methodTemplate = methodTemplate.replace(
			"${DTO_NAME}", openApiComponent.getName() + "DTO");

		StringBuilder sb = new StringBuilder();

		List<OpenApiProperty> openApiProperties =
			openApiComponent.getOpenApiProperties();

		Iterator<OpenApiProperty> iterator = openApiProperties.iterator();

		while (iterator.hasNext()) {
			OpenApiProperty openApiProperty = iterator.next();

			sb.append("\t\tjsonObject.put(\"");
			sb.append(openApiProperty.getName());
			sb.append("\", ");

			sb.append(
				_getProviderAwareValueExpression(
					openApiProperty.getJavaTypeProvider()));

			sb.append(");\n");
		}

		return "\n\n" + methodTemplate.replace(
			"${GET_DTO_METHOD_STATEMENTS}", sb.toString());
	}

	public String getImpliciteTargetType(String methodRootPath) {
		return StringUtils.upperCaseFirstChar(methodRootPath);
	}

	public String getPropertyAssertions(OpenApiComponent openApiComponent) {
		StringBuilder sb = new StringBuilder();

		List<OpenApiProperty> openApiProperties =
			openApiComponent.getOpenApiProperties();

		Iterator<OpenApiProperty> iterator = openApiProperties.iterator();

		while (iterator.hasNext()) {
			OpenApiProperty openApiProperty = iterator.next();

			sb.append("\"");
			sb.append(openApiProperty.getName());
			sb.append("\", equalTo(");
			sb.append("jsonObject.getString(\"");
			sb.append(openApiProperty.getName());
			sb.append("\")");
			sb.append(")");

			if (iterator.hasNext()) {
				sb.append(", \n\t\t\t");
			}
		}

		return sb.toString();
	}

	public String getTestMethodName(Method method) {
		return "test" + StringUtils.upperCaseFirstChar(method.getName());
	}

	public String replaceContentJSONNodeStatements(
			String methodTemplate, OpenApiComponent openApiComponent,
			Set<String> generatedPrivateGetters,
			Method compatibleHttpPostMethod)
		throws IOException {

		String privateGetDTOMethodCall =
			"_get" + openApiComponent.getName() + "DTOJSONObject();\n";

		if (!generatedPrivateGetters.contains(privateGetDTOMethodCall)) {
			generatedPrivateGetters.add(privateGetDTOMethodCall);

			methodTemplate = methodTemplate + getGetResourceDTOMethod(
				openApiComponent);
		}

		StringBuilder sb = new StringBuilder();

		sb.append("JSONObject jsonObject = ");
		sb.append(privateGetDTOMethodCall);

		if (compatibleHttpPostMethod != null) {
			sb.append("\n\t\t");
			sb.append(getTestMethodName(compatibleHttpPostMethod));
			sb.append("(jsonObject);\n");
		}

		return methodTemplate.replace("${CONTENT_JSON_NODE}", sb.toString());
	}

	public String replaceOverloadStatements(
		String methodTemplate, Method method) {

		if ("POST".equals(method.getHttpMethod())) {
			StringBuilder sb = new StringBuilder();

			sb.append("\n\tpublic void ${TEST_METHOD_NAME}() {\n");
			sb.append("\t\t${CONTENT_JSON_NODE}\n");
			sb.append("\t\t${TEST_METHOD_NAME}(jsonObject);\n");
			sb.append("\t}\n");

			String result = methodTemplate.replace("${CONTENT_JSON_NODE}", "");

			result = result.replace("${METHOD_OVERLOAD}", sb.toString());

			result = result.replace(
				"${METHOD_PARAMETER}", "JSONObject jsonObject");

			return result;
		}

		return methodTemplate;
	}

	public String replacePathWithPathParameterInjecterMethod(
		Path path, Method method) {

		String subresourcePath =
			_applicationBasePath + path.getPath() + method.getPath();

		StringBuilder sb = new StringBuilder();

		if (method.hasPathParams()) {
			sb.append("replacePathParametersWithTestValues(\n\t\t\t\t\"");
			sb.append(subresourcePath);
			sb.append("\",\n\t\t\t\tjsonObject)");
		}
		else {
			sb.append("\"");
			sb.append(subresourcePath);
			sb.append("\"");
		}

		return sb.toString();
	}

	public String replaceQueryParamSection(
		String methodTemplate, Method method) {

		StringBuilder sb = new StringBuilder();

		List<Parameter> parameters = method.getParameters();

		Iterator<Parameter> iterator = parameters.iterator();

		while (iterator.hasNext()) {
			Parameter parameter = iterator.next();

			if (!parameter.isRequired() ||
				!"query".equals(parameter.getLocation())) {

				continue;
			}

			sb.append("\"");
			sb.append(parameter.getName());
			sb.append("\", ");

			sb.append(
				_getProviderAwareValueExpression(
					parameter.getJavaTypeProvider()));

			sb.append(", ");
		}

		String queryParamSection = "";

		if (sb.length() > 0) {
			sb.setLength(sb.length() - 2);

			queryParamSection =
				".queryParam(\n\t\t\t" + sb.toString() + "\n\t\t)";
		}

		return methodTemplate.replace("${QUERY_PARAM}", queryParamSection);
	}

	public void writeClassSources() throws IOException {
		Set<OpenApiComponent> openApiComponents =
			_openApi.getOpenApiComponents();

		for (Path path : _openApi.getPaths()) {
			writeResourceSources(path, openApiComponents);
		}
	}

	protected String toResourceTestMethods(
			Path path, Set<OpenApiComponent> openApiComponents)
		throws IOException {

		StringBuilder sb = new StringBuilder();

		List<Method> methods = path.getMethods();

		Iterator<Method> iterator = methods.iterator();

		String template = getTemplate("test/test.method.tpl");

		Set<String> generatedPrivateGetters = new HashSet<>();

		while (iterator.hasNext()) {
			Method method = iterator.next();

			String methodTemplate = replaceOverloadStatements(template, method);

			methodTemplate = methodTemplate.replace(
				"${TEST_METHOD_NAME}", getTestMethodName(method));

			String httpMethod = method.getHttpMethod();

			methodTemplate = methodTemplate.replace(
				"${HTTP_METHOD}", httpMethod.toLowerCase());

			methodTemplate = methodTemplate.replace(
				"${PATH}",
				replacePathWithPathParameterInjecterMethod(path, method));

			List<Response> responses = method.getResponses();

			Response response = responses.get(0);

			methodTemplate = methodTemplate.replace(
				"${RESPONSE_CODE}", String.valueOf(response.getStatus()));

			Content requestBodyContent = method.getRequestBodyContent(
				"application/json");

			if (requestBodyContent != null) {
				Schema schema = requestBodyContent.getSchema();

				if (schema != null) {
					OpenApiComponent openApiComponent =
						OpenApiComponentUtil.getOpenApiComponent(
							schema.getReference(), openApiComponents);

					methodTemplate = replaceContentJSONNodeStatements(
						methodTemplate, openApiComponent,
						generatedPrivateGetters, null);

					methodTemplate = methodTemplate.replace(
						"${BODY_CONTENT_TYPE}",
						".contentType(\n\t\t\tContentType.fromContentType(\"" +
							"application/json\")\n\t\t)");

					methodTemplate = methodTemplate.replace(
						"${REQUEST_BODY_STATEMENTS}",
						".body(\n\t\t\tjsonObject.toString()\n\t\t)");
				}
			}

			methodTemplate = replaceQueryParamSection(methodTemplate, method);

			if (method.hasResponseContent()) {
				if (method.hasCollectionReturnType(openApiComponents)) {
					OpenApiComponent openApiComponent =
						OpenApiComponentUtil.getByName(
							method.getReturnType(openApiComponents),
							openApiComponents);

					methodTemplate = methodTemplate.replace(
						"${CLIENT_ACCEPTS}",
						".accept(\n\t\t\tContentType.fromContentType(\"" +
							"application/json\")\n\t\t)");

					methodTemplate = replaceContentJSONNodeStatements(
						methodTemplate, openApiComponent,
						generatedPrivateGetters,
						getCompatibleHttpPostMethod(
							method.getReturnType(openApiComponents),
							"application/json", path.getMethods(),
							openApiComponents));

					methodTemplate = methodTemplate.replace(
						"${RESPONSE_BODY_ASSERTIONS}",
						";\n\t\t// TODO: implement pagination object " +
							"validation");

				}
				else {
					OpenApiComponent openApiComponent =
						OpenApiComponentUtil.getByName(
							method.getReturnType(openApiComponents),
							openApiComponents);

					String responseBodyStatements =
						".assertThat(\n\t\t).body(\n\t\t\t" +
							getPropertyAssertions(openApiComponent) + "\n\t\t)";

					methodTemplate = methodTemplate.replace(
						"${RESPONSE_BODY_ASSERTIONS}", responseBodyStatements);
					methodTemplate = methodTemplate.replace(
						"${CLIENT_ACCEPTS}",
						".accept(\n\t\t\tContentType.fromContentType(\"" +
							"application/json\")\n\t\t)");

					if (method.isHttpPostMethod()) {
						methodTemplate = replaceContentJSONNodeStatements(
							methodTemplate, openApiComponent,
							generatedPrivateGetters, null);
					}
					else {
						methodTemplate = replaceContentJSONNodeStatements(
							methodTemplate, openApiComponent,
							generatedPrivateGetters,
							getCompatibleHttpPostMethod(
								method.getReturnType(openApiComponents),
								"application/json", path.getMethods(),
								openApiComponents));
					}
				}
			}
			else {
				String targetType = getImpliciteTargetType(
					method.getModelName());

				Method compatibleHttpPostMethod = getCompatibleHttpPostMethod(
					targetType, "application/json", path.getMethods(),
					openApiComponents);

				if (compatibleHttpPostMethod == null) {
					_logger.warn(
						"Unable to find compatible POST method for {} {}",
						method.getHttpMethod(), method.getAbsolutePath());

					continue;
				}

				methodTemplate = replaceContentJSONNodeStatements(
					methodTemplate,
					OpenApiComponentUtil.getByName(
						targetType, openApiComponents),
					generatedPrivateGetters, compatibleHttpPostMethod);
			}

			methodTemplate = methodTemplate.replace("${CONTENT_JSON_NODE}", "");
			methodTemplate = methodTemplate.replace(
				"${REQUEST_BODY_STATEMENTS}", "");
			methodTemplate = methodTemplate.replace("${QUERY_PARAM}", "");
			methodTemplate = methodTemplate.replace("${CLIENT_ACCEPTS}", "");
			methodTemplate = methodTemplate.replace("${BODY_CONTENT_TYPE}", "");
			methodTemplate = methodTemplate.replace(
				"${RESPONSE_BODY_ASSERTIONS}", "");
			methodTemplate = methodTemplate.replace("${METHOD_OVERLOAD}", "");
			methodTemplate = methodTemplate.replace("${METHOD_PARAMETER}", "");

			sb.append(methodTemplate);

			if (iterator.hasNext()) {
				sb.append("\n");
			}
		}

		return sb.toString();
	}

	protected void writeResourceSources(
			Path path, Set<OpenApiComponent> openApiComponents)
		throws IOException {

		_writeResourceImplementationSource(path, openApiComponents);
	}

	private String _getProviderAwareValueExpression(Provider javaTypeProvider) {
		if ("String".equals(javaTypeProvider.getModelName()) ||
			"Date".equals(javaTypeProvider.getModelName())) {

			return "\"test_value\"";
		}

		return "1";
	}

	private void _writeResourceImplementationSource(
			Path path, Set<OpenApiComponent> openApiComponents)
		throws IOException {

		String resourceTestClassName = StringUtils.upperCaseFirstChar(
			path.getName() + "ResourceTest");

		String componentSourcePath = getTestClassSourcePath(
			_moduleOutputPath, resourceTestClassName + ".java",
			_resourceTestPackagePath);

		if (!_overwriteImplementation && exists(componentSourcePath)) {
			_logger.warn(
				"Resource implementation source file {} is not generated. " +
					"Configure overwrite mode in config file.",
				componentSourcePath);

			return;
		}

		String osgiResourceComponent = getTemplate(
			_TEMPLATE_FILE_RESOURCE_TEST);

		osgiResourceComponent = osgiResourceComponent.replace(
			"${PACKAGE}", _resourceTestPackagePath);

		osgiResourceComponent = osgiResourceComponent.replace(
			"${JAVA_IMPORT_STATEMENTS}", "");

		osgiResourceComponent = osgiResourceComponent.replace(
			"${AUTHOR}", _author);

		osgiResourceComponent = osgiResourceComponent.replace(
			"${JAVAX_IMPORT_STATEMENTS}", "");

		osgiResourceComponent = osgiResourceComponent.replace(
			"${RESOURCE_TEST_CLASS}", resourceTestClassName);

		String resourceInterfaceClassName = StringUtils.upperCaseFirstChar(
			path.getName() + "Resource");

		osgiResourceComponent = osgiResourceComponent.replace(
			"${MODEL_RESOURCE_INTERFACE_CLASS}", resourceInterfaceClassName);

		osgiResourceComponent = osgiResourceComponent.replace(
			"${PATH}", path.getName());

		osgiResourceComponent = osgiResourceComponent.replace(
			"${METHODS}", toResourceTestMethods(path, openApiComponents));

		writeSource(osgiResourceComponent, componentSourcePath);
	}

	private static final String _TEMPLATE_FILE_RESOURCE_TEST =
		"ResourceTest.java.tpl";

	private static final Logger _logger = LoggerFactory.getLogger(
		ResourceTestGenerator.class);

	private final String _applicationBasePath;
	private final String _author;
	private final String _moduleOutputPath;
	private final OpenApi _openApi;
	private final boolean _overwriteImplementation;
	private final String _resourceTestPackagePath;

}