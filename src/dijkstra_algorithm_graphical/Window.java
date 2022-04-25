package dijkstra_algorithm_graphical;

import java.awt.GridLayout;
import java.util.*;

import javax.swing.*;

public class Window {

	Node[][] nodeArray = new Node[10][10];
	List<Node> neighborList = new ArrayList<Node>();
	
	public Window() {
		JFrame frame = new JFrame("dijkstra algorithm");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(50, 50, 500, 500);
		frame.setLayout(new GridLayout(10,10));
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Node node = new Node();
				node.setPos(j, i);
				nodeArray[j][i] = node;
				frame.add(node);
			}
		}
		frame.show();
	}
}
