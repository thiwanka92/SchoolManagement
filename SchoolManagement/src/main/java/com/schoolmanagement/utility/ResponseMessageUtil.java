package com.schoolmanagement.utility;

import org.json.simple.JSONObject;

public class ResponseMessageUtil {
	private static final String CREATE_SUCCESS = "Record successfully created";
	private static final String DELETE_SUCCESS = "Record successfully deleted";
	private static String UPDATE_SUCCESS = "Record successfully updated";
	
	private static final String COMMON_ERROR = "Something wrong..! - cause by : ";
	static JSONObject object = new JSONObject();
	
	public static String getCreateSuccess() {
		return CREATE_SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public static String getCreateSuccessMessage() {
		object.put("msg", CREATE_SUCCESS);
		return object.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public static String getDeleteSuccessMessage() {
		object.put("msg", DELETE_SUCCESS);
		return object.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public static String getUpdateSuccessMessage() {
		object.put("msg", UPDATE_SUCCESS);
		return object.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public static String getCommonErrorMessage(String causeBy) {
		object.put("msg", COMMON_ERROR + causeBy);
		return object.toJSONString();
	}
	
	
}
