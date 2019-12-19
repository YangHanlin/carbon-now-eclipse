package com.carbon.now.eclipse.service.impl;

import com.carbon.now.eclipse.exception.CarbonNowException;
import com.carbon.now.eclipse.exception.WebBrowserException;
import com.carbon.now.eclipse.service.WebBrowserService;
import java.awt.Desktop;
import java.net.URI;

public class WebBrowserServiceImpl implements WebBrowserService {
	@Override
	public void openBrowserByUrl(String url) throws CarbonNowException {
		if (!Desktop.isDesktopSupported())
			throw new WebBrowserException("Desktop is not supported");
		Desktop desktop = Desktop.getDesktop();
		if (!desktop.isSupported(Desktop.Action.BROWSE))
			throw new WebBrowserException("Desktop does not support the action of browsing");
		try {
			desktop.browse(new URI(url));
		} catch (Exception e) {
			throw new CarbonNowException("Internal exception: <" + e.getClass().getSimpleName() + "> " + e.getMessage());
		}
	}
}
