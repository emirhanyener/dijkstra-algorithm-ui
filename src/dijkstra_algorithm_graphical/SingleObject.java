package dijkstra_algorithm_graphical;

public class SingleObject {
	private static SingleObject single;
	public Window currentWindow = null;
	
	private SingleObject() {
		
	}
	
	public static SingleObject InstantiateObj() {
		if(single == null)
			single = new SingleObject();
		return single;
	}
}
