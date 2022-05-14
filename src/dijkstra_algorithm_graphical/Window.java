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
	private JFrame frame;
	private JLabel statusLabel;
	private JLabel startLabel;
	private JLabel targetLabel;
	private JLabel stepLabel;
	
	private NodeManagement nodeManager;

	public NodeManagement getNodeManager() {
		return nodeManager;
	}
	
	//init
	public Window(int xSize, int ySize) {
		frame = new JFrame("Dijkstra's Shortest Path Algorithm");
		frame.setBounds(50, 50, 800, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setJMenuBar(new WindowMenu());
		
		nodeManager = new NodeManagement(NodeMapCreator.CreateNodeMap(xSize, ySize, SingleObject.InstantiateObj().getNodeAction()), xSize, ySize);
		
		//right panel (info and button)
		JPanel panelRight = new JPanel();
		panelRight.setBounds(550, 25, 200, 500);
		panelRight.setLayout(new GridLayout(10,1));

		//help button
		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowHelpPane();
			}
		});
		
		//neighbour nodes 
		JButton neighbourNodesButton = new JButton("Neighbour Nodes");
		neighbourNodesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowNeighbourNodes();
			}
		});
		
		//visited nodes
		JButton visitedNodesButton = new JButton("Visited Nodes");
		visitedNodesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowVisitedNodes();
			}
		});
		
		//status label
		statusLabel = new JLabel();
		setStatusLabel("NODE INFO");
		
		//step label
		stepLabel = new JLabel();
		stepLabel.setText("Step 0");

		//nodes panel add (left panel)
		JPanel panelNodes = new JPanel();
		panelNodes.setBounds(25, 25, 500, 500);
		panelNodes.setLayout(new GridLayout(10,10));
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				panelNodes.add(nodeManager.getNode(i, j));
			}
		}
		
		//start label
		startLabel = new JLabel();
		startLabel.setText("Start Node : (" + nodeManager.getStart().getXPos() + ", " + nodeManager.getStart().getYPos() + ")");
		
		//target label
		targetLabel = new JLabel();
		targetLabel.setText("Target Node : (" + nodeManager.getTarget().getXPos() + ", " + nodeManager.getTarget().getYPos() + ")");

		//add panel all components
		panelRight.add(statusLabel);
		panelRight.add(stepLabel);
		panelRight.add(startLabel);
		panelRight.add(targetLabel);
		panelRight.add(helpButton);
		panelRight.add(neighbourNodesButton);
		panelRight.add(visitedNodesButton);
		frame.add(panelRight);
		frame.add(panelNodes);
		frame.show();
	}
	
	//label setters
	public void setStepLabel(int step) {
		stepLabel.setText("Step : " + step);
	}
	public void setStatusLabel(String status) {
		statusLabel.setText("Click Mode : " + status);
	}
	public void SetTargetLabel(String pos) {
		targetLabel.setText("Target Node : (" + nodeManager.getTarget().getXPos() + ", " + nodeManager.getTarget().getYPos() + ")");
	}
	public void SetStartLabel(String pos) {
		startLabel.setText("Start Node : (" + nodeManager.getStart().getXPos() + ", " + nodeManager.getStart().getYPos() + ")");
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	//neighbour nodes form
	private void ShowNeighbourNodes() {
		if(nodeManager.getNeighbourList().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "neighbour nodes is empty");
			return;
		}
		String neighbours[][] = new String[nodeManager.getNeighbourList().size()][3];
		int itemCounter = 0;
		for(Node item : nodeManager.getNeighbourList()) {
			neighbours[itemCounter][0] = String.valueOf(item.getXPos());
			neighbours[itemCounter][1] = String.valueOf(item.getYPos());
			if(item.getNodeParent() == null)
				neighbours[itemCounter][2] = "null";
			else
			neighbours[itemCounter][2] = "(" + String.valueOf(item.getNodeParent().getXPos()) + ", " + String.valueOf(item.getNodeParent().getYPos()) + ")";
			itemCounter++;
		}
		new NeighbourNodesForm(nodeManager.getStepCount(), neighbours);
	}
	
	//visited nodes form
	private void ShowVisitedNodes() {
		if(nodeManager.getVisitedList().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "visited nodes is empty");
			return;
		}
		String visitedNodes[][] = new String[nodeManager.getVisitedList().size()][3];
		int itemCounter = 0;
		for(Node item : nodeManager.getVisitedList()) {
			visitedNodes[itemCounter][0] = String.valueOf(item.getXPos());
			visitedNodes[itemCounter][1] = String.valueOf(item.getYPos());
			if(item.getNodeParent() == null)
				visitedNodes[itemCounter][2] = "null";
			else
				visitedNodes[itemCounter][2] = "(" + String.valueOf(item.getNodeParent().getXPos()) + ", " + String.valueOf(item.getNodeParent().getYPos()) + ")";
			itemCounter++;
		}
		new NeighbourNodesForm(nodeManager.getStepCount(), visitedNodes);
	}
	
	//help pane
	public void ShowHelpPane() {
		JOptionPane.showMessageDialog(frame, "T : Select new target node"
				+ "\nS : Select new start node"
				+ "\nB : Block / unblock node"
				+ "\nI : Node info"
				+ "\nR : Reset all"
				+ "\nSpace : Next step");
	}
}