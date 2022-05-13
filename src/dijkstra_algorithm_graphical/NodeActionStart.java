package dijkstra_algorithm_graphical;

public class NodeActionStart implements INodeAction{
	@Override
	public void NodeEvent(Node node) {
		SingleObject.InstantiateObj().getCurrentWindow().getNodeManager().setStart(node);
	}
}
