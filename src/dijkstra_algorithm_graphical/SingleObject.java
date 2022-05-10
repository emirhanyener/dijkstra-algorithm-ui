package dijkstra_algorithm_graphical;

import java.util.ArrayList;
import java.util.List;

public class SingleObject {
	private static SingleObject single = null;
	public List<Node> neighbourList = new ArrayList<Node>();
	public Node target = null;
	public Node start = null;
	public boolean isFounded = false;
	public Node tempNode = null;
	public int stepCount = 0;
	
	private SingleObject() {
		
	}
	
	public static SingleObject InstantiateObject() {
		if(single == null)
			single = new SingleObject();
		return single;
	}
}