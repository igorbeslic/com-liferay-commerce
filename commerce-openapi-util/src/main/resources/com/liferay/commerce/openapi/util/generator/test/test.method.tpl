
	@Test${METHOD_OVERLOAD}
	public void ${TEST_METHOD_NAME}(${METHOD_PARAMETER}) {
		${CONTENT_JSON_NODE}
		RestAssured.given(
		).request(
		).auth(
		).preemptive(
		).basic(
			USER, PASSWORD
		)${CLIENT_ACCEPTS}${BODY_CONTENT_TYPE}${REQUEST_BODY_STATEMENTS}${QUERY_PARAM}.when(
		).${HTTP_METHOD}(
			${PATH}
		).then(
		).statusCode(
			${RESPONSE_CODE}
		)${RESPONSE_BODY_ASSERTIONS};
	}