package gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGroup extends JPanel {
	
	private int cols; // numero de colunas
	
	private JLabel title[];
	private JPanel panel[];
	
	public MenuGroup(int columns) {
		cols = columns;
		title = new JLabel[cols];
		panel = new JPanel[cols];
		
		setLayout(new GridLayout(1,cols));
		
		for (int i=0; i<cols; i++) {
			panel[i] = new JPanel();
			add(panel[i]);
		}
	}
	
	
	public void setLabelNames(String str[]) {
		for (int i=0; i<cols; i++) {
			title[i].setText(str[i]);
		}
	}
	
}
