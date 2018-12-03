package gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGroup extends JPanel {
	
	private static final int cols = 3; // numero de colunas
	
	private static JLabel title[] = new JLabel[cols];
	private static JPanel panel[] = new JPanel[cols];
	
	public MenuGroup() {
		setLayout(new GridLayout(1, cols));
		for (int i=0; i<cols; i++) {
			title[i] = new JLabel("Titulo "+ (i+1));
			panel[i] = new JPanel();
			panel[i].setLayout(new GridLayout(4, 4));
			panel[i].setBorder(BorderFactory.createTitledBorder(getBorder()));
			panel[i].add(title[i]);
			add(panel[i]);
		}
	}

}
