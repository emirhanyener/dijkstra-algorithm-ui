package dijkstra_algorithm_graphical;

import javax.swing.JButton;

public class Node extends JButton{
	Node parentNode;
	int status;
	
	Node(){
		super();
		parentNode = null;
		status = 0;
	}
}
