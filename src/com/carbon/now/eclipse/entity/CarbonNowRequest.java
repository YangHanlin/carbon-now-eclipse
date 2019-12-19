package com.carbon.now.eclipse.entity;

import java.util.HashMap;
import java.util.Map;

public class CarbonNowRequest {
	static private final String PARAMETER_CODE = "code";
	
	private String code;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Map<String, String> toArgs() {
		HashMap<String, String> args = new HashMap<String, String>();
		args.put(PARAMETER_CODE, code);
		return args;
	}
}
