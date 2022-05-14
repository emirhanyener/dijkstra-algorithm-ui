package dijkstra_algorithm_graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WindowMenu extends JMenuBar{
	public WindowMenu() {
		JMenu menu = new JMenu("Window");
		JMenuItem newWindow = new JMenuItem("New Window");
		menu.add(newWindow);
		add(menu);
		
		newWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newWindowEvent();
			}
		});
	}
	
	public void newWindowEvent() {
		new NewWindowForm();
	}
}
