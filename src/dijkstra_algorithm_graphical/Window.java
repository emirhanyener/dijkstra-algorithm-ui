package dijkstra_algorithm_graphical;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	private JLabel statusLabel;
	private JLabel startLabel;
	private JLabel targetLabel;
	
	//init
	public Window() {
		frame = new JFrame("Dijkstra's Shortest Path Algorithm");
		frame.setBounds(50, 50, 800, 590);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(550, 25, 200, 500);
		panel.setLayout(new GridLayout(10,1));
		frame.add(panel);
		
		statusLabel = new JLabel();
		statusLabel.setText("Click Mode : INFO");
		panel.add(statusLabel);
		
		
		isFounded = false;
		//for step by step pathfinding
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
		
		InitWindow();
		
		target = nodeArray[5][8];
		start = nodeArray[0][0];

		ResetAll();
		

		startLabel = new JLabel();
		startLabel.setText("Start Node : (" + start.getXPos() + ", " + start.getYPos() + ")");
		panel.add(startLabel);
		
		targetLabel = new JLabel();
		targetLabel.setText("Target Node : (" + target.getXPos() + ", " + target.getYPos() + ")");
		panel.add(targetLabel);
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
		System.out.println(neighbourList.size());
		neighbourList.clear();
		System.out.println(neighbourList.size());
		SetNeighbour(start, null);
		
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
							JOptionPane.showMessageDialog(null, "target founded");
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
		}
		
		//if target is neighbour
		else {
			if(tempNode == null) {
				JOptionPane.showMessageDialog(null, "path founded");
				return;
			}
			tempNode.setBackground(Color.MAGENTA);
			tempNode = tempNode.getNodeParent();
		}
	}
	
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
	
	//node info method
	public void ShowNodeInfo(Node node) {
		//JOptionPane.showMessageDialog(null, "Node parent : (" + String.valueOf(nodeArray[0][0].getXPos()));
		if(node.getNodeParent() == null)
			JOptionPane.showMessageDialog(null, "Node parent : (null)\nXPos : " + String.valueOf(node.getXPos()) + "\nYPos : " + String.valueOf(node.getYPos()));
		else
			JOptionPane.showMessageDialog(null, "Node parent : (" + String.valueOf(node.getNodeParent().getXPos()) + ", " + String.valueOf(node.getNodeParent().getYPos()) + ")\nXPos : " + String.valueOf(node.getXPos()) + "\nYPos : " + String.valueOf(node.getYPos()));
	}

	public void SetTarget(Node node) {
		target.setBackground(Color.WHITE);
		target = node;
		target.setBackground(Color.GREEN);
		ResetAll();
		UpdateTargetLabel();
	}
	public void SetStart(Node node) {
		start.setBackground(Color.WHITE);
		start = node;
		start.setBackground(Color.YELLOW);
		ResetAll();
		UpdateStartLabel();
	}
	
	public void SetBlock(Node node) {
		node.ChangeBlockState();
	}
}