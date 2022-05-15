package utils;

public class NodeActionTarget implements INodeAction{
	@Override
	public void NodeEvent(Node node) {
		SingleObject.InstantiateObj().getCurrentWindow().getNodeManager().setTarget(node);
	}
}
