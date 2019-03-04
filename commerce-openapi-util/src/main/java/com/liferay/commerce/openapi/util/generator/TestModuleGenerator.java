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

import com.liferay.commerce.openapi.util.OpenApi;
import com.liferay.commerce.openapi.util.generator.exception.GeneratorException;
import com.liferay.commerce.openapi.util.importer.OpenAPIImporter;
import com.liferay.commerce.openapi.util.importer.OpenApiReader;
import com.liferay.commerce.openapi.util.importer.OpenApiReaderFactory;
import com.liferay.commerce.openapi.util.util.StringUtils;

import java.io.IOException;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Igor Beslic
 */
public class TestModuleGenerator extends BaseSourceGenerator {

	public TestModuleGenerator(Properties properties) {
		_applicationBase = properties.getProperty(
			"osgi.module.application.base");
		_author = properties.getProperty("osgi.module.author");

		_bundleName = properties.getProperty("osgi.module.bundle.name") +
			"Test";

		_bundleSymbolicName = properties.getProperty(
			"osgi.module.bundle.symbolic.name") + ".test";

		_bundleVersion = properties.getProperty("osgi.module.bundle.version");
		_configuration = properties;

		String moduleRootPath = properties.getProperty("osgi.module.root.path");

		if (StringUtils.isEmpty(moduleRootPath)) {
			throw new GeneratorException(
				"The generated module root path must be specified");
		}

		_moduleOutputPath = String.format(
			"%s/%s", moduleRootPath,
			properties.getProperty("osgi.module.name") + "-test");

		if ("true".equals(
				properties.getProperty(
					"osgi.module.generator.overwrite.bnd"))) {

			_overwriteBND = true;
		}
		else {
			_overwriteBND = false;
		}
	}

	public void generate() throws IOException {
		_generateModule();

		_logger.info("Module generated at location {}", _moduleOutputPath);
	}

	private void _generateModule() throws IOException {
		OpenApiReader openApiReader = OpenApiReaderFactory.getOpenApiReader(
			_configuration);

		OpenAPIImporter openAPIImporter = new OpenAPIImporter(openApiReader);

		OpenApi openApi = openAPIImporter.getOpenApi();

		try {
			checkModuleOutputPaths(_moduleOutputPath);

			_writeBNDSource();

			_writeGradleSource(openApi);

			_writeTestSources(openApi);
		}
		catch (Exception e) {
			throw new GeneratorException("Unable to generate module", e);
		}
	}

	private void _writeBNDSource() throws IOException {
		String bndSourcePath =
			_moduleOutputPath + "/" + _TEMPLATE_FILE_BND.replace(".tpl", "");

		if (!_overwriteBND && exists(bndSourcePath)) {
			_logger.warn(
				"BND source file {} is not generated. Configure overwrite " +
					"mode in config file.",
				bndSourcePath);

			return;
		}

		String bndTpl = getTemplate(_TEMPLATE_FILE_BND);

		bndTpl = bndTpl.replace("${BUNDLE_NAME}", _bundleName);
		bndTpl = bndTpl.replace("${BUNDLE_SYMBOLIC_NAME}", _bundleSymbolicName);
		bndTpl = bndTpl.replace("${BUNDLE_VERSION}", _bundleVersion);

		writeSource(bndTpl, bndSourcePath);
	}

	private void _writeGradleSource(OpenApi openApi) throws IOException {
		boolean overwriteBuildGradle = false;

		if ("true".equals(
				_configuration.getProperty(
					"osgi.module.generator.overwrite.gradle"))) {

			overwriteBuildGradle = true;
		}

		BuildGradleGenerator buildGradleGenerator = new BuildGradleGenerator(
			openApi.hasContextExtensions(), _moduleOutputPath,
			overwriteBuildGradle);

		buildGradleGenerator.writeSource();
	}

	private void _writeTestSources(OpenApi openApi) throws IOException {
		boolean overwriteImplementation = false;

		if ("true".equals(
				_configuration.getProperty(
					"osgi.module.generator.overwrite.implementation"))) {

			overwriteImplementation = true;
		}

		ResourceTestGenerator resourceGenerator = new ResourceTestGenerator(
			_applicationBase, _author, _moduleOutputPath,
			overwriteImplementation,
			_configuration.getProperty(
				"osgi.module.resource.interface.package"),
			openApi);

		resourceGenerator.writeClassSources();
	}

	private static final String _TEMPLATE_FILE_BND = "bnd.bnd.tpl";

	private static final Logger _logger = LoggerFactory.getLogger(
		TestModuleGenerator.class);

	private final String _applicationBase;
	private final String _author;
	private final String _bundleName;
	private final String _bundleSymbolicName;
	private final String _bundleVersion;
	private final Properties _configuration;
	private final String _moduleOutputPath;
	private final boolean _overwriteBND;

}