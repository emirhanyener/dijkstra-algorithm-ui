package utils;

import javax.swing.JOptionPane;

public class NodeActionInfo implements INodeAction{
	@Override
	public void NodeEvent(Node node) {
		JOptionPane.showMessageDialog(null, "Node parent : " 
				+ (node.getNodeParent() == null ? "(null)" : "(" + String.valueOf(node.getNodeParent().getXPos()) 
				+ ", " 
				+ String.valueOf(node.getNodeParent().getYPos()) 
				+ ")") 
				+ "\nX Posisiton : " 
				+ String.valueOf(node.getXPos()) 
				+ "\nY Position : " 
				+ String.valueOf(node.getYPos())
				+ "\nDistance From Target : " 
				+ String.valueOf(node.getDistanceFromSource()));
	}
}
