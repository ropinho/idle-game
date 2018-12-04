package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CharacterTab extends JPanel {
	
	JPanel intern[] = new JPanel[2];
	
	public CharacterTab() {
		initComponents();
		setLayout(new GridLayout(1,2));
		add(intern[0]);
		add(intern[1]);
	}
	
	private void initComponents() {
		JButton auxBtn;
		for (int i=0; i<2; i++) {
			intern[i] = new JPanel();
			intern[i].setLayout(new GridLayout(8,1));
		}
		intern[0].add(new JLabel("Distribuir pontos: "+ PlayFrame.idle.pointsToDistrib));
		intern[1].add(new JLabel("Equipar"));
		for (int i=0; i<6; i++) {
			auxBtn = new JButton(PlayFrame.idle.HERO.getAttrNames()[i]);
			intern[0].add(auxBtn);
		}
	}
	
}
