package dijkstra_algorithm_graphical;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NeighboursForm extends JFrame {
	public NeighboursForm(int step, String[][] datas) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Step " + step);
		setBounds(10, 10, 400, 300);
		String column[] = {"X Position", "Y Position", "Parent Node"};
		JTable table = new JTable(datas, column);
		add(table);
		add(new JScrollPane(table));
		show();
	}
}
