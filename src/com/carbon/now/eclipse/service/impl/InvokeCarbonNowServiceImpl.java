package com.carbon.now.eclipse.service.impl;

import java.util.Map;

import com.carbon.now.eclipse.entity.CarbonNowRequest;
import com.carbon.now.eclipse.service.InvokeCarbonNowService;

public class InvokeCarbonNowServiceImpl implements InvokeCarbonNowService {
	static private final String carbonNowUrl = "https://carbon.now.sh/";
	
	static private String toArgStr(Map<String, String> args) {
		StringBuilder argStrBuilder = new StringBuilder("?");
		for (String key : args.keySet())
			argStrBuilder.append(key + "=" + args.get(key) + "&");
		return argStrBuilder.toString();
	}
	
	@Override
	public void invokeCarbonNowWebsite(CarbonNowRequest request) {
		WebBrowserService webBrowserService = new WebBrowserService();
		webBrowserService.openUrl(carbonNowUrl + toArgStr(request.toArgs()));
	}
}
