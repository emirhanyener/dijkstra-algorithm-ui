package dijkstra_algorithm_graphical;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class NodeAction {
	private NodeActionList nodeActionList = new NodeActionList();
	private INodeAction nodeAction = new NodeActionInfo();
	
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
                    NodeActionListIterator actions = new NodeActionListIterator(nodeActionList);
                    
                    while(true) {
                    	if(actions.Current() == null) {
                    		break;
                    	}
                    	if(e.getKeyCode() == actions.Current().key) {
                    		nodeAction = actions.Current().nodeAction;
                        	SingleObject.InstantiateObj().currentWindow.setStatusLabel(actions.Current().info);
                    	}
                    	System.out.println(actions.Current().info);
                    	actions.Next();
                    }
				}
				return true;
			}
		});
	}
	
	public void NodeClick(Node node) {
		nodeAction.NodeEvent(node);
	}
	
	public void AddNodeAction(int _key, INodeAction _nodeAction, String _info) {
		nodeActionList.Add(_key, _nodeAction, _info);
	}
}
