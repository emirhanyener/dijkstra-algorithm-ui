package dijkstra_algorithm_graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewWindowForm extends JFrame{
	public NewWindowForm() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("New Window");
		
		JTextField widthTxt = new JTextField();
		JTextField heightTxt = new JTextField();
		JLabel widthLbl = new JLabel("Width : ");
		JLabel heightLbl = new JLabel("Height : ");
		JButton newBtn = new JButton("New Window");

		setBounds(10, 10, 300, 230);
		widthTxt.setBounds(70, 10, 190, 30);
		heightTxt.setBounds(70, 60, 190, 30);
		widthLbl.setBounds(10, 10, 50, 30);
		heightLbl.setBounds(10, 60, 50, 30);
		newBtn.setBounds(10, 110, 250, 70);
		
		newBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewWindow(Integer.parseInt(widthTxt.getText()), Integer.parseInt(heightTxt.getText()));
			}
		});
		
		add(widthTxt);
		add(heightTxt);
		add(widthLbl);
		add(heightLbl);
		add(newBtn);
		
		show();
	}
	
	public void NewWindow(int x, int y) {
		Window newWindow = new Window(x, y);
		SingleObject.InstantiateObj().setCurrentWindow(newWindow);
	}
}
