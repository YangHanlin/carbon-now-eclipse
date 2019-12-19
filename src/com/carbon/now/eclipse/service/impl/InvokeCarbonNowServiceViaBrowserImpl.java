package com.carbon.now.eclipse.service.impl;

import java.util.Map;

import com.carbon.now.eclipse.entity.CarbonNowRequest;
import com.carbon.now.eclipse.exception.CarbonNowException;
import com.carbon.now.eclipse.service.InvokeCarbonNowService;
import com.carbon.now.eclipse.service.WebBrowserService;

public class InvokeCarbonNowServiceViaBrowserImpl implements InvokeCarbonNowService {
	static private final String carbonNowUrl = "https://carbon.now.sh/";
	
	static private String toArgStr(Map<String, String> args) {
		StringBuilder argStrBuilder = new StringBuilder("?");
		for (String key : args.keySet())
			argStrBuilder.append(key + "=" + args.get(key) + "&");
		return argStrBuilder.toString();
	}
	
	@Override
	public void invokeCarbonNow(CarbonNowRequest request) throws CarbonNowException {
		WebBrowserService webBrowserService = new WebBrowserServiceImpl();
		webBrowserService.openBrowserByUrl(carbonNowUrl + toArgStr(request.toArgs()));
	}
}
