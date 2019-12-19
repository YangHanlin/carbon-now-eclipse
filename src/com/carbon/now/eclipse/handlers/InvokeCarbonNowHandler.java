package com.carbon.now.eclipse.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.carbon.now.eclipse.entity.CarbonNowRequest;
import com.carbon.now.eclipse.exception.CarbonNowException;
import com.carbon.now.eclipse.service.InvokeCarbonNowService;
import com.carbon.now.eclipse.service.impl.InvokeCarbonNowServiceViaBrowserImpl;
import com.carbon.now.eclipse.util.CarbonNowExceptionHandler;

public class InvokeCarbonNowHandler extends AbstractHandler {
	private String getCodeInEditor() {
		return null;
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		InvokeCarbonNowService invokeCarbonNowService = new InvokeCarbonNowServiceViaBrowserImpl();
		try {
			invokeCarbonNowService.invokeCarbonNow(new CarbonNowRequest(getCodeInEditor()));
		} catch (CarbonNowException e) {
			CarbonNowExceptionHandler exceptionHandler = new CarbonNowExceptionHandler(HandlerUtil.getActiveWorkbenchWindowChecked(event));
			if (exceptionHandler.handleException(e) == CarbonNowExceptionHandler.KEEP_THROW)
				throw new ExecutionException(e.getMessage());
		}
		return null;
	}
}
