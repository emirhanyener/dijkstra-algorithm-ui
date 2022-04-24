package dijkstra_algorithm_graphical;

import java.awt.GridLayout;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("dijkstra algorithm");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(50, 50, 500, 500);
		frame.setLayout(new GridLayout(10,10));

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton btn = new JButton();
				frame.add(btn);
			}
		}
		
		frame.show();
	}
}
