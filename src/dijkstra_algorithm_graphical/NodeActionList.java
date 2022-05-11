package dijkstra_algorithm_graphical;

public class NodeActionList {
	public int key;
	public INodeAction nodeAction;
	public String info;
	public NodeActionList next;
	
	public void Add(int _key, INodeAction _nodeAction, String _info) {
		if(next == null) {
			NodeActionList newAction = new NodeActionList();
			newAction.key = _key;
			newAction.nodeAction = _nodeAction;
			newAction.info = _info;
			next = newAction;
			return;
		}
		next.Add(_key, _nodeAction, _info);
	}
}
