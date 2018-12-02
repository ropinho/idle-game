package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CloseLoginScreen implements ActionListener {

	JButton button;
	JFrame frame;
	JTextField field1, field2;
	
	public CloseLoginScreen(JFrame f, JTextField tf1, JTextField tf2) {
		frame = f;
		field1 = tf1;
		field2 = tf2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String textName = field1.getText();
		String textClasse = field2.getText();
		
		// gera o herói
		Play.idle.HERO = Play.idle.createHero(textClasse, textName);
		Play.print("Personagem criado: "+ Play.idle.HERO.getName());
		
		frame.dispose();
	}
	
	

}
