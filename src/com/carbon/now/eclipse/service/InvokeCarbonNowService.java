package com.carbon.now.eclipse.service;

import com.carbon.now.eclipse.entity.CarbonNowRequest;
import com.carbon.now.eclipse.exception.CarbonNowException;

public interface InvokeCarbonNowService {
	public void invokeCarbonNow(CarbonNowRequest request) throws CarbonNowException;
}
