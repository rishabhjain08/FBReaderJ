package org.geometerplus.zlibrary.core.dialogs;

public abstract class ZLTreeSaveHandler extends ZLTreeHandler {
	public boolean isOpenHandler() {
		return false;
	}

	public abstract void processNode(ZLTreeNode node);
	
	public abstract boolean accept(String state);
}