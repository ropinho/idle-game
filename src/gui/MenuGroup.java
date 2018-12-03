package gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGroup extends JPanel {
	
	private final int cols = 3; // numero de colunas
	
	private JLabel title[] = new JLabel[cols];
	private JPanel panel[] = new JPanel[cols];
	
	public MenuGroup(String t1, String t2, String t3) {
		setLayout(new GridLayout(1, cols));
		title[0] = new JLabel(t1);
		title[1] = new JLabel(t2);
		title[2] = new JLabel(t3);
		for (int i=0; i<cols; i++) {
			panel[i] = new JPanel();
			panel[i].setLayout(new GridLayout(4, 4));
			panel[i].setBorder(BorderFactory.createTitledBorder(getBorder()));
			panel[i].add(title[i]);
			add(panel[i]);
		}
	}
}
