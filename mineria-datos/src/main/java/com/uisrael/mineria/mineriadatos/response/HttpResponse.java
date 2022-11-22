package com.uisrael.mineria.mineriadatos.response;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

	public Map<String, Object> sendResponse(String code, String status, String message, Object data) {
		HashMap<String, Object> response = new HashMap<>();
		response.put("code", code);
		response.put("status", status);
		response.put("message", message);
		response.put("data", data);
		return response;
	}

	public Map<String, Object> sendResponse(int code, String status, String message, Object data) {
		Map<String, Object> response = new HashMap<>();
		response.put("code", code);
		response.put("status", status);
		response.put("message", message);
		response.put("data", data);
		return response;
	}

}
