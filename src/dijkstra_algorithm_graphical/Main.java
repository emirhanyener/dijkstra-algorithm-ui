package dijkstra_algorithm_graphical;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.FileManager;
import utils.Node;
import utils.NodeAction;
import utils.NodeActionBlock;
import utils.NodeActionInfo;
import utils.NodeActionStart;
import utils.NodeActionTarget;
import utils.SingleObject;
import utils.Window;

public class Main {
	private NodeAction nodeAction = new NodeAction();
	private Node nodeArray[][];
	private Window window;
	
	public Main() {
		nodeAction.AddNodeAction(KeyEvent.VK_T, new NodeActionTarget(), "Target Node");
		nodeAction.AddNodeAction(KeyEvent.VK_S, new NodeActionStart(), "Start Node");
		nodeAction.AddNodeAction(KeyEvent.VK_B, new NodeActionBlock(), "Node Block");
		nodeAction.AddNodeAction(KeyEvent.VK_I, new NodeActionInfo(), "Node Info");
		SingleObject.InstantiateObj().setNodeAction(nodeAction);
		CreateWindow();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void CreateWindow() {
		//default window creation
		window = new Window(10, 10);
		SingleObject.InstantiateObj().setCurrentWindow(window);
	}
}
