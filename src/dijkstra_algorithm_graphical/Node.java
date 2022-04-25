package dijkstra_algorithm_graphical;

import javax.swing.JButton;

public class Node extends JButton{
	private Node parentNode;
	private int status;
	private int xPos;
	private int yPos;
	
	Node(){
		super();
		parentNode = null;
		status = 0;
	}
	
	public void setPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	public void setVisited(Node parent) {
		this.status = 2;
		parentNode = parent;
	}
	public void setNeighbour() {
		this.status = 1;
	}
	public int getStatus() {
		return this.status;
	}
	public int getX() {
		return this.xPos;
	}
	public int getY() {
		return this.yPos;
	}
}
