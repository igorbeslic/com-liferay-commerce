	private JSONObject _get${DTO_NAME}JSONObject() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

${GET_DTO_METHOD_STATEMENTS}

		return jsonObject;
	}