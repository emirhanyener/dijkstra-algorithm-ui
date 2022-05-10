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

public class Window{
	private Node[][] nodeArray = new Node[10][10];
	private List<Node> neighbourList = new ArrayList<Node>();
	private Node target;
	private Node start;
	private JFrame frame;
	private boolean isFounded;
	private Node tempNode;
	private char mode = 'i';
	private int stepCount;
	private JLabel statusLabel;
	private JLabel startLabel;
	private JLabel targetLabel;
	private JLabel stepLabel;
	
	//init
	public Window() {
		frame = new JFrame("Dijkstra's Shortest Path Algorithm");
		frame.setBounds(50, 50, 800, 590);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		JButton neighboursButton = new JButton("Neighbours");
		neighboursButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowNeighbours();
			}
		});
		
		isFounded = false;
		
		statusLabel = new JLabel();
		statusLabel.setText("Click Mode : NODE INFO");
		stepLabel = new JLabel();
		stepLabel.setText("Step 0");

		//keyboard action
		/*
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
	        @Override
	        public boolean dispatchKeyEvent(KeyEvent ke) {
                if( ke.getID() == KeyEvent.KEY_PRESSED) {
                    if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                		StepByStep();
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_R) {
                		ResetAll();
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_T) {
                		mode = 't';
                		statusLabel.setText("Click Mode : TARGET NODE");
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_S) {
                		mode = 's';
                		statusLabel.setText("Click Mode : START NODE");
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_B) {
                		mode = 'b';
                		statusLabel.setText("Click Mode : NODE BLOCK");
                    }
                    if (ke.getKeyCode() == KeyEvent.VK_I) {
                		mode = 'i';
                		statusLabel.setText("Click Mode : NODE INFO");
                    }
                }
        		return true;
	        }
	    });
		*/
		InitWindow();
		
		target = nodeArray[5][8];
		start = nodeArray[0][0];

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

	public void UpdateTargetLabel() {
		targetLabel.setText("Target Node : (" + target.getXPos() + ", " + target.getYPos() + ")");
	}
	public void UpdateStartLabel() {
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
				Node node = new Node();
				node.setXPos(j);
				node.setYPos(i);
				nodeArray[j][i] = node;
				nodeArray[j][i].setBackground(Color.WHITE);
				node.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						NodeClickAction(node);
					}
				});
				panel.add(node);
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
	public void NodeClickAction(Node node) {
		if(mode == 'i') {
			ShowNodeInfo(node);
		}
		if(mode == 't') {
			SetTarget(node);
		}
		if(mode == 'b') {
			SetBlock(node);
		}
		if(mode == 's') {
			SetStart(node);
		}
	}
	
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
		UpdateTargetLabel();
	}
	
	//set start node
	public void SetStart(Node node) {
		start.setBackground(Color.WHITE);
		start = node;
		start.setBackground(Color.YELLOW);
		ResetAll();
		UpdateStartLabel();
	}
	
	//block or unblock node
	public void SetBlock(Node node) {
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