package dijkstra_algorithm_graphical;

import java.awt.Color;

import javax.swing.JButton;

public class Node extends JButton{
	private Node parentNode;
	private int xPos;
	private int yPos;
	private boolean isBlock;
	private float distanceFromSource;
	
	Node(){
		super();
		isBlock = false;
		parentNode = null;
		distanceFromSource = 0;
	}
	
	public void ResetNode() {
		parentNode = null;
		isBlock = false;
		distanceFromSource = 0;
	}
	
	//getters setters
	public void setNodePos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	public void setNodeVisited(Node parent) {
		parentNode = parent;
	}
	public Node getNodeParent() {
		return parentNode;
	}
	public void setNodeParent(Node parent) {
		parentNode = parent;
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
	public void setDistanceFromSource(float value) {
		distanceFromSource = value;
	}
	public float getDistanceFromSource() {
		return distanceFromSource;
	}
}
