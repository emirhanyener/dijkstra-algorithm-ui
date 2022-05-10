package dijkstra_algorithm_graphical;

import javax.swing.JOptionPane;

public class NodeActionInfo implements INodeAction{
	@Override
	public void NodeEvent(Node node) {
		JOptionPane.showMessageDialog(null, "Node parent : " 
				+ (node.getNodeParent() == null ? "(null)" : "(" + String.valueOf(node.getNodeParent().getXPos()) 
				+ ", " 
				+ String.valueOf(node.getNodeParent().getYPos()) 
				+ ")") 
				+ "\nXPos : " 
				+ String.valueOf(node.getXPos()) 
				+ "\nYPos : " 
				+ String.valueOf(node.getYPos()));
	}
}
