package dijkstra_algorithm_graphical;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class ClickMode {
	char mode = 'i';
	public ClickMode(INodeClickAction window) {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if(e.getID() == KeyEvent.KEY_PRESSED) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                		window.StepByStep();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_R) {
                    	window.ResetAll();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_T) {
                		mode = 't';
                    }
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                		mode = 's';
                    }
                    if (e.getKeyCode() == KeyEvent.VK_B) {
                		mode = 'b';
                    }
                    if (e.getKeyCode() == KeyEvent.VK_I) {
                		mode = 'i';
                    }
				}
				return true;
			}
		});
	}
	
	
}