package dijkstra_algorithm_graphical;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class NewWindowForm extends JFrame{
	public NewWindowForm() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("New Window");
		setBounds(10, 10, 100, 100);
		JTextField width = new JTextField();
		JTextField height = new JTextField();
		width.setBounds(10, 10, 80, 30);
		height.setBounds(10, 60, 80, 30);
		add(width);
		add(height);
		show();
	}
}
