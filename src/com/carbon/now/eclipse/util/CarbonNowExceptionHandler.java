package com.carbon.now.eclipse.util;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;

import com.carbon.now.eclipse.exception.CarbonNowException;

public class CarbonNowExceptionHandler {
	public static final int STOP_THROW = 0,
			                KEEP_THROW = 1;
	
	public static final String DEFAULT_TITLE = "Error";
	
	private IWorkbenchWindow workbenchWindow;
	
	public CarbonNowExceptionHandler(IWorkbenchWindow workbenchWindow) {
		this.workbenchWindow = workbenchWindow;
	}
	
	public IWorkbenchWindow getWorkbenchWindow() {
		return workbenchWindow;
	}
	
	public void setWorkbenchWindow(IWorkbenchWindow workbenchWindow) {
		this.workbenchWindow = workbenchWindow;
	}
	
	public int handleException(CarbonNowException exception) {
		MessageDialog.openError(workbenchWindow.getShell(), DEFAULT_TITLE, exception.getFullMessage());
		return STOP_THROW;
	}
}
