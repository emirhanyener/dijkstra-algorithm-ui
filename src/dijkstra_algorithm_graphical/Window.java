package dijkstra_algorithm_graphical;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.util.*;

import javax.swing.*;

public class Window implements INodeClickAction{
	private JFrame frame;
	private JLabel statusLabel;
	private JLabel startLabel;
	private JLabel targetLabel;
	private JLabel stepLabel;
	
	public List<Node> neighbourList = new ArrayList<Node>();
	public Node target = null;
	public Node start = null;
	public boolean isFounded = false;
	public Node tempNode = null;
	public int stepCount = 0;
	public Node[][] nodeArray;
	
	//init
	public Window(int xSize, int ySize) {
		frame = new JFrame("Dijkstra's Shortest Path Algorithm");
		frame.setBounds(50, 50, 800, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		nodeArray = NodeMapCreator.CreateNodeMap(xSize, ySize);
		target = nodeArray[5][6];
		start = nodeArray[1][1];
		
		JPanel panel = new JPanel();
		panel.setBounds(550, 25, 200, 500);
		panel.setLayout(new GridLayout(10,1));

		//help button
		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowHelpPane();
			}
		});
		//neighbours button
		JButton neighboursButton = new JButton("Neighbours");
		neighboursButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowNeighbours();
			}
		});
		
		statusLabel = new JLabel();
		setStatusLabel("NODE INFO");
		
		stepLabel = new JLabel();
		stepLabel.setText("Step 0");

		InitWindow();
		

		ResetAll();
		
		startLabel = new JLabel();
		startLabel.setText("Start Node : (" + start.getXPos() + ", " + start.getYPos() + ")");
		
		targetLabel = new JLabel();
		targetLabel.setText("Target Node : (" + target.getXPos() + ", " + target.getYPos() + ")");


		panel.add(statusLabel);
		panel.add(stepLabel);
		panel.add(startLabel);
		panel.add(targetLabel);
		panel.add(helpButton);
		panel.add(neighboursButton);
		frame.add(panel);
	}
	
	
	public void setStatusLabel(String status) {
		statusLabel.setText("Click Mode : " + status);
	}

	public void SetTargetLabel(String pos) {
		targetLabel.setText("Target Node : (" + target.getXPos() + ", " + target.getYPos() + ")");
	}
	public void SetStartLabel(String pos) {
		startLabel.setText("Start Node : (" + start.getXPos() + ", " + start.getYPos() + ")");
	}
	
	public void ResetAll() {
		isFounded = false;
		//reset nodes
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				nodeArray[j][i].setBackground(Color.WHITE);
				nodeArray[j][i].ResetNode();
			}
		}

		target.setBackground(Color.GREEN);
		start.setBackground(Color.YELLOW);
		//clear neighbourList
		neighbourList.clear();
		SetNeighbour(start, null);
		stepCount = 0;
		stepLabel.setText("Step 0");
	}
	
	//create buttons and frame
	public void InitWindow() {
		JPanel panel = new JPanel();
		panel.setBounds(25, 25, 500, 500);
		panel.setLayout(new GridLayout(10,10));
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				panel.add(nodeArray[j][i]);
			}
		}
		frame.add(panel);
		frame.show();
	}
	
	
	public void SetNeighbour(Node node, Node parentNode) {
		node.setBackground(Color.ORANGE);
		node.setNodeParent(parentNode);
		neighbourList.add(node);
	}
	
	//if neighbourList has node
	public boolean isHasNode(Node node) {
		for(Node item : neighbourList) {
			if(item == node)
				return true;
		}
		return false;
	}
	
	//print neighbour list to console
	public void PrintNeighbourList() {
		for(Node item : neighbourList) {
			System.out.println("(" + String.valueOf(item.getXPos()) + ", " + String.valueOf(item.getYPos()) + ")");
		}
	}
	
	//method for step by step pathfinding (default space press)
	public void StepByStep() {
		PrintNeighbourList();
		if(!isFounded) {
			//neighbour find
			for (int i = -1; i < 2 && !isFounded; i++) {
				for (int j = -1; j < 2 && !isFounded; j++) {
					if(neighbourList.get(0).getXPos() + j >= 0 && neighbourList.get(0).getXPos() + j < 10 && neighbourList.get(0).getYPos() + i >= 0 && neighbourList.get(0).getYPos() + i < 10) {
						System.out.println("neighbour ( " + (neighbourList.get(0).getXPos() + j) +  ", "+ (neighbourList.get(0).getYPos() + i)+" ) : " + String.valueOf(isHasNode(nodeArray[neighbourList.get(0).getXPos() + j][neighbourList.get(0).getYPos() + i])));
						if(nodeArray[neighbourList.get(0).getXPos() + j][neighbourList.get(0).getYPos() + i].getBlockState())
							continue;
						if(nodeArray[neighbourList.get(0).getXPos() + j][neighbourList.get(0).getYPos() + i] == target){
							isFounded = true;
							JOptionPane.showMessageDialog(frame, "target founded");
							tempNode = target;
						}
						if(!isHasNode(nodeArray[neighbourList.get(0).getXPos() + j][neighbourList.get(0).getYPos() + i]) && nodeArray[neighbourList.get(0).getXPos() + j][neighbourList.get(0).getYPos() + i].getNodeStatus() != 1){
							SetNeighbour(nodeArray[neighbourList.get(0).getXPos() + j][neighbourList.get(0).getYPos() + i], nodeArray[neighbourList.get(0).getXPos()][neighbourList.get(0).getYPos()]);
							System.out.println("neighbour ( " + (neighbourList.get(0).getXPos() + j) +  ", "+ (neighbourList.get(0).getYPos() + i)+" ) added ");
						}
					}
				}
			}
			neighbourList.get(0).setBackground(Color.RED);
			neighbourList.remove(0);
			
			stepCount++;
		}
		//if target is founded
		else {
			if(tempNode == null) {
				JOptionPane.showMessageDialog(frame, "path founded");
				return;
			}
			tempNode.setBackground(Color.MAGENTA);
			tempNode = tempNode.getNodeParent();
			stepCount++;
		}
		stepLabel.setText("Step " + stepCount);
	}
	
	private void ShowNeighbours() {
		if(neighbourList.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "neighbours is empty");
		}
		String neighbours[][] = new String[neighbourList.size()][3];
		int itemCounter = 0;
		for(Node item : neighbourList) {
			neighbours[itemCounter][0] = String.valueOf(item.getXPos());
			neighbours[itemCounter][1] = String.valueOf(item.getYPos());
			if(item.getNodeParent() == null)
				neighbours[itemCounter][2] = "null";
			else
			neighbours[itemCounter][2] = "(" + String.valueOf(item.getNodeParent().getXPos()) + ", " + String.valueOf(item.getNodeParent().getYPos()) + ")";
			itemCounter++;
		}
		new NeighboursForm(stepCount, neighbours);
	}
	
	//click action
	/*
	public void NodeClickAction(Node node) {
		if(mode == 'i') {
			ShowNodeInfo(node);
		}
		if(mode == 't') {
			SetTarget(node);
		}
		if(mode == 'b') {
			ChangeNodeBlock(node);
		}
		if(mode == 's') {
			SetStart(node);
		}
	}*/
	
	//node info
	public void ShowNodeInfo(Node node) {
		JOptionPane.showMessageDialog(null, "Node parent : " + (node.getNodeParent() == null ? "(null)" : "(" + String.valueOf(node.getNodeParent().getXPos()) + ", " + String.valueOf(node.getNodeParent().getYPos()) + ")") + "\nXPos : " + String.valueOf(node.getXPos()) + "\nYPos : " + String.valueOf(node.getYPos()));
	}
	
	//set target node
	public void SetTarget(Node node) {
		target.setBackground(Color.WHITE);
		target = node;
		target.setBackground(Color.GREEN);
		ResetAll();
		//UpdateTargetLabel();
	}
	
	//set start node
	public void SetStart(Node node) {
		start.setBackground(Color.WHITE);
		start = node;
		start.setBackground(Color.YELLOW);
		ResetAll();
		//UpdateStartLabel();
	}
	
	//block or unblock node
	public void ChangeNodeBlock(Node node) {
		node.ChangeBlockState();
	}
	
	//help panel
	public void ShowHelpPane() {
		JOptionPane.showMessageDialog(frame, "T : Select new target node"
				+ "\nS : Select new start node"
				+ "\nB : Block / unblock node"
				+ "\nI : Node info"
				+ "\nR : Reset all"
				+ "\nSpace : Next step");
	}
}