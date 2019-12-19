package com.carbon.now.eclipse.exception;

public class CarbonNowException extends Exception {
	public CarbonNowException(String msg) {
		super(msg);
	}
	
	public String getFullMessage() {
		return "Unidentified error:\n" + getMessage();
	}
}
