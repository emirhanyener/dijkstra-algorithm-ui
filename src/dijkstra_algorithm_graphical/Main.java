package dijkstra_algorithm_graphical;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private NodeAction clickMode;
	private Node nodeArray[][];
	private Window window;
	
	public Main() {
		CreateWindow();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void CreateWindow() {
		window = new Window(10, 10);
		SingleObject.InstantiateObj().currentWindow = window;
	}
}
