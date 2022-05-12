package dijkstra_algorithm_graphical;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class NodeManagement {

	public List<Node> neighbourList = new ArrayList<Node>();
	public List<Node> visitedList = new ArrayList<Node>();
	
	public Node target = null;
	public Node start = null;
	public Node tempNode = null;
	public Node[][] nodeArray;
	
	public boolean isFounded = false;
	public int stepCount = 0;
	
	public NodeManagement(Node[][] nodeArray) {
		this.nodeArray = nodeArray;
		start = nodeArray[0][0];
		target = nodeArray[9][9];
		ResetAll();
	}

	public void addNeighbourNode(Node node) {
		neighbourList.add(node);
	}
	public void addVisited(Node node) {
		visitedList.add(node);
	}
	
	public void setNeighbourList(List<Node> neighbourList) {
		this.neighbourList = neighbourList;
	}
	public void setNodeArray(Node[][] nodeArray) {
		this.nodeArray = nodeArray;
	}
	public void setStart(Node start) {
		start.setBackground(Color.WHITE);
		this.start = start;
		start.setBackground(Color.YELLOW);
		ResetAll();
	}
	public void setTarget(Node target) {
		target.setBackground(Color.WHITE);
		this.target = target;
		target.setBackground(Color.GREEN);
		ResetAll();
	}
	public void setTempNode(Node tempNode) {
		this.tempNode = tempNode;
	}
	public void setVisitedList(List<Node> visitedList) {
		this.visitedList = visitedList;
	}
	public void setFounded(boolean value) {
		isFounded = value;
	}
	public void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}
	public void stepCountNext() {
		stepCount++;
	}
	
	public List<Node> getNeighbourList() {
		return neighbourList;
	}
	public Node[][] getNodeArray() {
		return nodeArray;
	}
	public Node getStart() {
		return start;
	}
	public Node getTarget() {
		return target;
	}
	public Node getTempNode() {
		return tempNode;
	}
	public List<Node> getVisitedList() {
		return visitedList;
	}
	public int getStepCount() {
		return stepCount;
	}
	public boolean isFounded() {
		return isFounded;
	}
	
	public Node getNode(int x, int y) {
		return nodeArray[x][y];
	}
	
	public void ResetAll() {
		isFounded = false;
		//reset nodes
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				getNode(j, i).setBackground(Color.WHITE);
				getNode(j, i).ResetNode();
			}
		}

		target.setBackground(Color.GREEN);
		start.setBackground(Color.YELLOW);
		//clear neighbourList
		neighbourList.clear();
		visitedList.clear();
		SetNeighbour(start, null);
		stepCount = 0;
		Window window = SingleObject.InstantiateObj().currentWindow;
	}

	public void SetNeighbour(Node node, Node parentNode) {
		node.setBackground(Color.ORANGE);
		node.setNodeParent(parentNode);
		neighbourList.add(node);
	}
	

	//method for step by step pathfinding (default space press)
	public void NextStep() {
		UpdateDistance();
		Node node = GetLowerNode();
		if(!isFounded) {
			//neighbour find
			for (int i = -1; i < 2 && !isFounded; i++) {
				for (int j = -1; j < 2 && !isFounded; j++) {
					if(node.getXPos() + j >= 0 && node.getXPos() + j < 10 && node.getYPos() + i >= 0 && node.getYPos() + i < 10) {
						if(getNode(node.getXPos() + j, node.getYPos() + i).getBlockState())
							continue;
						if(getNode(node.getXPos() + j, node.getYPos() + i) == getTarget()){
							setFounded(true);
							JOptionPane.showMessageDialog(null, "target founded");
							setTempNode(getTarget());
						}
						if(!isNeighbour(getNode(node.getXPos() + j, node.getYPos() + i)) && !isVisited(getNode(node.getXPos() + j, node.getYPos() + i))){
							SetNeighbour(getNode(node.getXPos() + j, node.getYPos() + i), getNode(node.getXPos(), node.getYPos()));
						}
					}
				}
			}
			node.setBackground(Color.RED);
			getVisitedList().add(node);
			getNeighbourList().remove(node);

			stepCountNext();
		}
		//if target is founded
		else {
			if(getTempNode() == null) {
				JOptionPane.showMessageDialog(null, "path founded");
				return;
			}
			getTempNode().setBackground(Color.MAGENTA);
			setTempNode(getTempNode().getNodeParent());
			stepCountNext();
		}
		SingleObject.InstantiateObj().currentWindow.setStepLabel(stepCount);
	}
	

	public void UpdateDistance() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				getNode(j, i).setDistanceFromSource(CalculateDistance(getNode(j, i).getXPos(), getStart().getXPos(), getNode(j, i).getYPos(), getStart().getYPos()));
			}
		}
		
	}
	
	public float CalculateDistance(int x1, int x2, int y1, int y2) {
		float distance = 0;
		float xDistance = abs(x2 - x1);
		float yDistance = abs(y2 - y1);
		if(xDistance >= 1 && yDistance >= 1) {
			if(xDistance < yDistance) {
				distance += xDistance * 1.4f;
				distance += yDistance - xDistance;
			}
			else {
				distance += yDistance * 1.4f;
				distance += xDistance - yDistance;
			}
		}
		else {
			distance += xDistance;
			distance += yDistance;
		}
		return distance;
	}
	
	public Node GetLowerNode() {
		Node node = getNeighbourList().get(0);
		for(Node item : getNeighbourList()) {
			if(item.getDistanceFromSource() < node.getDistanceFromSource())
				node = item;
		}
		return node;
	}
	
	public int abs(int value){
		if(value < 0)
			return (value * -1);
		return value;
	}
	

	
	//if neighbourList has node
	public boolean isNeighbour(Node node) {
		for(Node item : getNeighbourList()) {
			if(item == node)
				return true;
		}
		return false;
	}
	public boolean isVisited(Node node) {
		for(Node item : getVisitedList()) {
			if(item == node)
				return true;
		}
		return false;
	}
}
