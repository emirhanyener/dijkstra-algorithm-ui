package dijkstra_algorithm_graphical;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class NodeMapCreator {
	public NodeMapCreator() {
		
	}

	public static JPanel CreateNodeMapPanel(int xSize, int ySize){
		Node[][] nodeArray = new Node[ySize][xSize];
		JPanel panel = new JPanel();
		panel.setBounds(25, 25, 500, 500);
		panel.setLayout(new GridLayout(10,10));
		NodeAction nodeAction = new NodeAction();
		
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
						nodeAction.NodeClick(node); 
					}
				});
				panel.add(node);
			}
		}
		return panel;
	}
	public static Node[][] CreateNodeMap(int xSize, int ySize, NodeAction nodeAction){
		Node[][] nodeArray = new Node[ySize][xSize];
		//NodeAction nodeAction = new NodeAction();
		
		for (int i = 0; i < ySize; i++) {
			for (int j = 0; j < xSize; j++) {
				Node node = new Node();
				node.setXPos(j);
				node.setYPos(i);
				nodeArray[j][i] = node;
				nodeArray[j][i].setBackground(Color.WHITE);
				node.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						nodeAction.NodeClick(node); 
					}
				});
			}
		}
		return nodeArray;
	}
}
