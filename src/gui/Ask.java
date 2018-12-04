package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ask extends JFrame {

	JButton yes, no;
	JPanel mainPanel;
	JFrame self;
	
	public Ask() {
		self = this;
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 350, 300, 100);
		add(mainPanel);
	}
	
	
	private void initComponents() {
		mainPanel = new JPanel(new BorderLayout());
		
		JPanel lblPergunta = new JPanel(new BorderLayout());
		JLabel pergunta = new JLabel(PlayFrame.idle.HERO.getName() + " morreu! Deseja reviver?");
		lblPergunta.add(pergunta, BorderLayout.CENTER);
		
		JPanel panelBotoes = new JPanel(new GridLayout(1, 2));
		
		/* Botão SIM */
		
		yes = new JButton("Sim");
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayFrame.idle.exploration.setExit(false);
				System.out.println("Voce escolheu SIM");
				System.out.println("Thread exploração reiniciada");
				self.dispose();
			}
		});
		panelBotoes.add(yes);
		
		/* Botão NÃO */
		
		no = new JButton("Não");
		no.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayFrame.idle.exploration.setExit(true);
				self.dispose();
			}
		});
		panelBotoes.add(no);
		
		mainPanel.add(lblPergunta, BorderLayout.NORTH);
		mainPanel.add(panelBotoes, BorderLayout.CENTER);
	}
}
