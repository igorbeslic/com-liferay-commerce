jar.enabled = false
unzipJar.enabled = false

copyLibs {
	enabled = true
}

dependencies {
	compileOnly group: "io.rest-assured", name: "rest-assured", version: "3.3.0"

	testIntegrationCompile group: "com.liferay", name: "com.liferay.arquillian.extension.junit.bridge", version: "1.0.7"
	testIntegrationCompile group: "com.liferay.portal", name: "release.portal.api", version: "7.1.1"
	testIntegrationCompile group: "javax.ws.rs", name: "javax.ws.rs-api", version: "2.1"
	testIntegrationCompile group: "junit", name: "junit", version: "4.12"

	testIntegrationRuntime project(":apps:commerce:commerce-openapi-admin")
}