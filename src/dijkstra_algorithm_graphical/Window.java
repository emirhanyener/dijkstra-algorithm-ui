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
	private JFrame frame;
	private boolean isFounded;
	private Node tempNode;
	
	//init
	public Window() {
		isFounded = false;
		//for step by step pathfinding
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
	        @Override
	        public boolean dispatchKeyEvent(KeyEvent ke) {
	                if( ke.getID() == KeyEvent.KEY_PRESSED) {
	                    if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
	                		StepByStep();
	                    }
	                }
	        		return true;
	        }
	    });
		
		InitWindow();
		
		target = nodeArray[5][8];

		SetNeighbour(nodeArray[0][0], null);
	}
	
	//create buttons and frame
	public void InitWindow() {
		frame = new JFrame("dijkstra algorithm");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(50, 50, 500, 500);
		frame.setLayout(new GridLayout(10,10));
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Node node = new Node();
				node.setXPos(j);
				node.setYPos(i);
				nodeArray[j][i] = node;
				node.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ShowNodeInfo(node);
					}
				});
				frame.add(node);
			}
		}
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
	
	//node info method
	public void ShowNodeInfo(Node node) {
		//JOptionPane.showMessageDialog(null, "Node parent : (" + String.valueOf(nodeArray[0][0].getXPos()));
		if(node.getNodeParent() == null)
			JOptionPane.showMessageDialog(null, "Node parent : (null)\nXPos : " + String.valueOf(node.getXPos()) + "\nYPos : " + String.valueOf(node.getYPos()));
		else
			JOptionPane.showMessageDialog(null, "Node parent : (" + String.valueOf(node.getNodeParent().getXPos()) + ", " + String.valueOf(node.getNodeParent().getYPos()) + ")\nXPos : " + String.valueOf(node.getXPos()) + "\nYPos : " + String.valueOf(node.getYPos()));
	}
}