package com.carbon.now.eclipse.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;

import com.carbon.now.eclipse.entity.CarbonNowRequest;
import com.carbon.now.eclipse.exception.CarbonNowException;
import com.carbon.now.eclipse.service.InvokeCarbonNowService;
import com.carbon.now.eclipse.service.impl.InvokeCarbonNowServiceViaBrowserImpl;
import com.carbon.now.eclipse.util.CarbonNowExceptionHandler;

public class InvokeCarbonNowHandler extends AbstractHandler {
	private String getCodeInEditor() {
		final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor == null || !(activeEditor instanceof ITextEditor))
			return null;
		ITextEditor activeTextEditor = (ITextEditor) activeEditor;
		IDocument document = activeTextEditor.getDocumentProvider().getDocument(activeTextEditor.getEditorInput());
		if (document == null)
			return null;
		return document.get();
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		InvokeCarbonNowService invokeCarbonNowService = new InvokeCarbonNowServiceViaBrowserImpl();
		try {
			String code = getCodeInEditor();
			if (code == null)
				return null;
			invokeCarbonNowService.invokeCarbonNow(new CarbonNowRequest(code));
		} catch (CarbonNowException e) {
			CarbonNowExceptionHandler exceptionHandler = new CarbonNowExceptionHandler(HandlerUtil.getActiveWorkbenchWindowChecked(event));
			if (exceptionHandler.handleException(e) == CarbonNowExceptionHandler.KEEP_THROW)
				throw new ExecutionException(e.getMessage());
		}
		return null;
	}
}
