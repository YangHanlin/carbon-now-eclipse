package com.carbon.now.eclipse.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.carbon.now.eclipse.entity.CarbonNowRequest;
import com.carbon.now.eclipse.exception.CarbonNowException;
import com.carbon.now.eclipse.service.InvokeCarbonNowService;
import com.carbon.now.eclipse.service.WebBrowserService;

public class InvokeCarbonNowServiceViaBrowserImpl implements InvokeCarbonNowService {
	static private final String carbonNowUrl = "https://carbon.now.sh/";
	
	static private String encode(String str) throws CarbonNowException {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new CarbonNowException("Internal exception: unsupported encoding");
		}
	}
	
	static private String toArgStr(Map<String, String> args) throws CarbonNowException {
		StringBuilder argStrBuilder = new StringBuilder("?");
		for (String key : args.keySet())
			argStrBuilder.append(encode(key) + "=" + encode(args.get(key)) + "&");
		argStrBuilder.deleteCharAt(argStrBuilder.length() - 1);
		return argStrBuilder.toString();
	}
	
	@Override
	public void invokeCarbonNow(CarbonNowRequest request) throws CarbonNowException {
		WebBrowserService webBrowserService = new WebBrowserServiceImpl();
		webBrowserService.openBrowserByUrl(carbonNowUrl + toArgStr(request.toArgs()));
	}
}
