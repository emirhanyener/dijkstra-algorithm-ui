package dijkstra_algorithm_graphical;

import java.awt.Color;

import javax.swing.JButton;

public class Node extends JButton{
	private Node parentNode;
	private int status;
	private int xPos;
	private int yPos;
	private boolean isBlock;
	
	Node(){
		super();
		isBlock = false;
		parentNode = null;
		status = 0;
	}
	
	public void ResetNode() {
		status = 0;
		parentNode = null;
		isBlock = false;
	}
	
	//getters setters
	public void setNodePos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	public void setNodeVisited(Node parent) {
		this.status = 1;
		parentNode = parent;
	}
	public Node getNodeParent() {
		return parentNode;
	}
	public void setNodeParent(Node parent) {
		parentNode = parent;
		this.status = 1;
	}
	public int getNodeStatus() {
		return this.status;
	}
	public int getXPos() {
		return this.xPos;
	}
	public int getYPos() {
		return this.yPos;
	}
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	public void ChangeBlockState() {
		isBlock = !isBlock;
		if(isBlock)
			this.setBackground(Color.BLACK);
		else
			this.setBackground(Color.WHITE);
	}
	public boolean getBlockState() {
		return isBlock;
	}
}
