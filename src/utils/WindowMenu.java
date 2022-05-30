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
		JMenu node = new JMenu("Node");
		JMenuItem newWindow = new JMenuItem("New");
		JMenuItem sample1 = new JMenuItem("Easy");
		JMenuItem sample2 = new JMenuItem("Medium");
		JMenuItem sample3 = new JMenuItem("Hard");
		JMenuItem sample4 = new JMenuItem("Maze");
		JMenuItem saveNode = new JMenuItem("Save");
		JMenuItem loadNode = new JMenuItem("Load");
		menu.add(newWindow);
		sample.add(sample1);
		sample.add(sample2);
		sample.add(sample3);
		sample.add(sample4);
		node.add(saveNode);
		node.add(loadNode);
		add(menu);
		add(sample);
		add(node);
		
		newWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newWindowEvent();
			}
		});
		
		/*
		 * sample
		 * 
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
		
		saveNode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveNode();
			}
		});
		
		loadNode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadNode();
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
	
	public void saveNode() {
		String value = SingleObject.InstantiateObj().getCurrentWindow().getNodeManager().xSize + "," + SingleObject.InstantiateObj().getCurrentWindow().getNodeManager().ySize + "-";

		NodeManagement manager = SingleObject.InstantiateObj().getCurrentWindow().getNodeManager();
		for(int i = 0; i < manager.ySize; i++) {
			for(int j = 0; j < manager.xSize; j++) {
				if(manager.getNode(i, j).getBlockState())
					value += 1;
				else
					value += 0;
			}
			if(i != manager.ySize - 1)
				value += ";";
		}
		
		value += "-" + manager.target.getXPos() + "," + manager.target.getYPos();
		
		FileManager.Write("savedNode.dat", value);
	}
	
	public void loadNode() {
		String saved = FileManager.Read("savedNode.dat");
		
		Window newWindow = new Window(Integer.valueOf(saved.split("-")[0].split(",")[0]), Integer.valueOf(saved.split("-")[0].split(",")[1]));
		SingleObject.InstantiateObj().getCurrentWindow().getFrame().dispose();
		SingleObject.InstantiateObj().setCurrentWindow(newWindow);
		NodeManagement manager = newWindow.getNodeManager();
		
		manager.setTarget(manager.getNode(Integer.valueOf(saved.split("-")[2].split(",")[0]), Integer.valueOf(saved.split("-")[2].split(",")[1])));
		
		for(int i = 0; i < Integer.valueOf(saved.split("-")[0].split(",")[0]); i++) {
			for(int j = 0; j < Integer.valueOf(saved.split("-")[0].split(",")[1]); j++) {
				//System.out.print(j + "," + i + "(" + Integer.valueOf(String.valueOf(Character.toChars((int)saved.split("-")[1].split(";")[i].charAt(j)))) + ");");
				if(Integer.valueOf(String.valueOf(Character.toChars((int)saved.split("-")[1].split(";")[i].charAt(j)))) == 1) {
					
					manager.getNode(i, j).ChangeBlockState();
				}
			}
			//System.out.println();
		}
	}
}
