package dijkstra_algorithm_graphical;

public class NodeActionTarget implements INodeAction{
	@Override
	public void NodeEvent(Node node) {
		SingleObject.InstantiateObj().currentWindow.SetTarget(node);
	}
}
