package utils;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NodeAction implements KeyListener{
	private NodeActionList nodeActionList = new NodeActionList();
	private INodeAction nodeAction = new NodeActionInfo();
	
	public NodeAction() {
		/*
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				return true;
			}
		});*/
	}
	
	public void SetEvent(KeyEvent e) {
		if(e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        		SingleObject.InstantiateObj().getCurrentWindow().getNodeManager().NextStep();
            }
            if (e.getKeyCode() == KeyEvent.VK_R) {
        		SingleObject.InstantiateObj().getCurrentWindow().getNodeManager().ResetAll();
            }
            NodeActionListIterator actions = new NodeActionListIterator(nodeActionList);
            
            while(true) {
            	if(actions.Current() == null) {
            		break;
            	}
            	if(e.getKeyCode() == actions.Current().key) {
            		nodeAction = actions.Current().nodeAction;
                	SingleObject.InstantiateObj().getCurrentWindow().setStatusLabel(actions.Current().info);
            	}
            	actions.Next();
            }
		}
	}
	
	//all nodes action
	public void NodeClick(Node node) {
		nodeAction.NodeEvent(node);
	}
	
	//add event
	public void AddNodeAction(int _key, INodeAction _nodeAction, String _info) {
		nodeActionList.Add(_key, _nodeAction, _info);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		SetEvent(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}