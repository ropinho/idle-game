package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import util.Bag;

public class Play extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static Controller idle;

	private static JPanel mainContainer;
	private static JTabbedPane multiAbas;
	private static JPanel panelCharacter, panelBag, panelPlay, panelSettings;
	static JTextArea console;
	static JTextArea bagInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					idle = new Controller();
					Play frame = new Play();
					frame.initCharacterCreation();
					frame.setVisible(true);
					frame.idle.exploration.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Play() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 640);
		setTitle("World of Idle");
		mainContainer = new JPanel();
		mainContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainContainer.setLayout(new BorderLayout(0, 0));
		setContentPane(mainContainer);
		
		/* creating multiply tabs */
		multiAbas = new JTabbedPane();
		panelCharacter = new JPanel();
		panelBag = new JPanel();
		panelPlay = new JPanel();
		panelSettings = new JPanel();
		
		initPlayTab();
		initBagTab();
		
		/* adding all tabs */
		multiAbas.add("Personagem", panelCharacter);
		multiAbas.add("Mochila", panelBag);
		multiAbas.add("Jogo", panelPlay);
		multiAbas.add("Config", panelSettings);
		mainContainer.add(multiAbas);
		
	}
	
	private void initCharacterCreation() {
		initCharacterTab();	
	}

	/* Character tab */
	private static void initCharacterTab() {
		JPanel panel = new JPanel();

		JLabel lblClasse = new JLabel("Classe");
		JTextField fieldClasse = new JTextField(2);
		
		JLabel lblNome = new JLabel("Nome");
		JTextField fieldNome = new JTextField(20);
		
		panel.add(new JLabel("Criar Personagem"));
		panel.add(lblClasse);
		panel.add(fieldClasse);
		panel.add(lblNome);
		panel.add(fieldNome);
		panelCharacter.add(panel);
	}
	
	/* Play tab */
	private static void initPlayTab() {
		console = new JTextArea(32, 64);
		console.setEditable(false);
		
		panelPlay.add(console);
	}
	
	
	/* Backpack tab */
	private static void initBagTab() {
		JPanel painel = new JPanel();
		bagInfo = new JTextArea(20, 32);
		Bag.showInfo();
		painel.add(bagInfo);
		panelBag.add(painel);
	}
	
	
	/*
	 * public methods for interactions with classes of others packages
	 * */
	public static void print(String str) {
		console.append(str);
	}
}
