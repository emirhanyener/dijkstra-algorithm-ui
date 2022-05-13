package dijkstra_algorithm_graphical;

public class SingleObject {
	private static SingleObject single;
	private Window currentWindow = null;
	
	private SingleObject() {
		
	}
	
	public static SingleObject InstantiateObj() {
		if(single == null)
			single = new SingleObject();
		return single;
	}
	
	public void setCurrentWindow(Window window) {
		currentWindow = window;
	}
	public Window getCurrentWindow() {
		return currentWindow;
	}
}
