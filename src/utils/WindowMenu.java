package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WindowMenu extends JMenuBar{
	public WindowMenu() {
		JMenu menu = new JMenu("Window");
		JMenu sample = new JMenu("Sample");
		JMenuItem newWindow = new JMenuItem("New Window");
		JMenuItem sample1 = new JMenuItem("Easy");
		JMenuItem sample2 = new JMenuItem("Medium");
		JMenuItem sample3 = new JMenuItem("Hard");
		JMenuItem sample4 = new JMenuItem("Maze");
		menu.add(newWindow);
		sample.add(sample1);
		sample.add(sample2);
		sample.add(sample3);
		sample.add(sample4);
		add(menu);
		add(sample);
		
		newWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newWindowEvent();
			}
		});
		
		/*
		short[][] matris = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		createSample(matris);
		 */
		
		sample1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				short[][] matris = {
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
				};
				createSample(matris, 9, 9);
			}
		});		
		
		sample2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				short[][] matris = {
					{0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
					{0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
					{0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
					{0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
					{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
				};
				createSample(matris, 9, 0);
			}
		});
		
		sample3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				short[][] matris = {
					{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
				};
				createSample(matris, 2, 0);
			}
		});
		
		sample4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				short[][] matris = {
						{0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
						{0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
						{0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
						{0, 0, 0, 1, 0, 1, 0, 0, 1, 0},
						{0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
						{0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
						{1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
						{1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
					};
				createSample(matris, 9, 9);
			}
		});
	}
	
	public void newWindowEvent() {
		new NewWindowForm();
	}
	
	public void createSample(short[][] blockMatris, int targetX, int targetY) {
		Window newWindow = new Window(10, 10);
		SingleObject.InstantiateObj().getCurrentWindow().getFrame().dispose();
		SingleObject.InstantiateObj().setCurrentWindow(newWindow);
		NodeManagement manager = newWindow.getNodeManager();
		manager.setTarget(manager.getNode(targetY, targetX));
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(blockMatris[j][i] == 1) {
					manager.getNode(j, i).ChangeBlockState();
				}
			}
		}
	}
}
