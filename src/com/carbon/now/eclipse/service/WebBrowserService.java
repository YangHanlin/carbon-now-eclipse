package com.carbon.now.eclipse.service;

import com.carbon.now.eclipse.exception.CarbonNowException;

public interface WebBrowserService {
	public void openBrowserByUrl(String url) throws CarbonNowException;
}
