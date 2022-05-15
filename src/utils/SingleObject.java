package utils;

public class SingleObject {
	private static SingleObject single;
	private Window currentWindow = null;
	private NodeAction nodeAction = null;
	
	private SingleObject() {
		
	}
	
	public static SingleObject InstantiateObj() {
		if(single == null)
			single = new SingleObject();
		return single;
	}
	
	public void setCurrentWindow(Window window) {
		currentWindow = null;
		currentWindow = window;
	}
	public void setNodeAction(NodeAction nodeAction) {
		this.nodeAction = nodeAction;
	}
	
	public Window getCurrentWindow() {
		return currentWindow;
	}
	public NodeAction getNodeAction() {
		return nodeAction;
	}
}
