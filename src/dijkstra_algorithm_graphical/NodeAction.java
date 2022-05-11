package dijkstra_algorithm_graphical;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class NodeAction {
	
	private INodeAction nodeAction = nodeAction = new NodeActionInfo();
	public NodeAction() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if(e.getID() == KeyEvent.KEY_PRESSED) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                		SingleObject.InstantiateObj().currentWindow.NextStep();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_R) {
                    	SingleObject.InstantiateObj().currentWindow.ResetAll();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_T) {
                    	nodeAction = new NodeActionTarget();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                    	nodeAction = new NodeActionStart();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_B) {
                    	nodeAction = new NodeActionBlock();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_I) {
                		nodeAction = new NodeActionInfo();
                    }
				}
				return true;
			}
		});
	}
	
	public void NodeClick(Node node) {
		nodeAction.NodeEvent(node);
	}
}
