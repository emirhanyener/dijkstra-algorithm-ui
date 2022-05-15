package utils;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VisitedNodesForm extends JFrame {
	public VisitedNodesForm(int step, String[][] datas) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Visited Nodes (Step : " + step + ")");
		setBounds(10, 10, 400, 300);
		String column[] = {"X Position", "Y Position", "Came From"};
		JTable table = new JTable(datas, column);
		add(table);
		add(new JScrollPane(table));
		show();
	}
}
