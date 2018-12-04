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
		/*
		 * Ação do botão "CRIAR"
		 * */
		String textName = field1.getText();
		String textClasse = field2.getText();
		
		// gera o herói
		PlayFrame.idle.createHero(textClasse, textName);
		PlayFrame.print("Personagem criado: "+ PlayFrame.idle.HERO.getName() + "\n");
		
		frame.dispose(); // fecha a janela de criação
		
		PlayFrame.initCharacterTab(); // inicia os componentes da aba do Personagem

		PlayFrame.idle.exploration.start(); /* Inicia o loop do Jogo */
	}
	
	

}
