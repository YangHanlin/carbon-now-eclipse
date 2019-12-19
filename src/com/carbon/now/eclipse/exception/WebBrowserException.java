package com.carbon.now.eclipse.exception;

public class WebBrowserException extends CarbonNowException {
	public WebBrowserException(String msg) {
		super(msg);
	}
	
	@Override
	public String getFullMessage() {
		return "Web Browser Error:\n" + getMessage();
	}
}
