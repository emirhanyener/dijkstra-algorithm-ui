package utils;

public class NodeActionBlock implements INodeAction{
	@Override
	public void NodeEvent(Node node) {
		node.ChangeBlockState();
	}
}
