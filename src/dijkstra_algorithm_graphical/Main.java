package dijkstra_algorithm_graphical;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private NodeAction nodeAction = new NodeAction();
	private Node nodeArray[][];
	private Window window;
	
	public Main() {
		CreateWindow();
		nodeAction.AddNodeAction(KeyEvent.VK_T, new NodeActionTarget(), "Target Node");
		nodeAction.AddNodeAction(KeyEvent.VK_S, new NodeActionStart(), "Start Node");
		nodeAction.AddNodeAction(KeyEvent.VK_B, new NodeActionBlock(), "Node Block");
		nodeAction.AddNodeAction(KeyEvent.VK_I, new NodeActionInfo(), "Node Info");
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void CreateWindow() {
		window = new Window(10, 10, nodeAction);
		SingleObject.InstantiateObj().currentWindow = window;
	}
}
