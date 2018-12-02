package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.Play;

public class JoinScreen extends JFrame {
	
	private JPanel contentPane;
	private JPanel fields;
	private JTextField fieldName, fieldClasse;
	private JLabel lblTitle, lblName, lblClasse;
	private JButton btnCreate;
	
	
	public JoinScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(3, 1));
		setTitle("Criar Personagem");
		setContentPane(contentPane);
		
		/* construct the 1st line of grid panels */
		JPanel panelTitle = new JPanel();
		lblTitle = new JLabel("Criar Personagem");
		panelTitle.add(lblTitle);
		contentPane.add(panelTitle);
		
		/* construct the 2nd line of grid panels */
		fields = new JPanel(new GridLayout(2,2));
		lblName = new JLabel("Nome:");
		fields.add(lblName);
		fieldName = new JTextField(20);
		fields.add(fieldName);
		lblClasse = new JLabel("Classe:");
		fields.add(lblClasse);
		fieldClasse = new JTextField(2);
		fields.add(fieldClasse);
		contentPane.add(fields);
		
		/* construct the 3rd line of grid panels */
		JPanel panelSubmit = new JPanel();
		btnCreate = new JButton("CRIAR");
		panelSubmit.add(btnCreate);
		contentPane.add(panelSubmit);
		
		btnCreate.addActionListener(new CloseLoginScreen(this, fieldName, fieldClasse));
		
	}

}
