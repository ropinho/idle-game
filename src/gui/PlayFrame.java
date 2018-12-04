package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import util.Bag;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;

public class PlayFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/* public */
	public static Controller idle;

	/* package */
	static JTextArea console;
	static JTextArea bagInfo;
	static JTextArea textArea[] =  new JTextArea[3];
	
	/* private */
	private JPanel mainContainer;
	private JTabbedPane multiAbas;
	private static JPanel panelCharacter, panelBag, panelPlay, panelSettings, auxPanel;
	private static MenuGroup belowConsoleMenu, characterMenu;
	
	private static final Font CONSOLE_FONT = new Font("Ubuntu Mono", Font.PLAIN, 18);
	private static final Font INFO_FONT = new Font("Arial", Font.PLAIN, 18);
	//private static final Font INFO_FONT_BOLD = new Font("Arial", Font.BOLD, 18);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JoinScreen join = new JoinScreen();
					join.setVisible(true);
					
					PlayFrame frame = new PlayFrame();
					frame.setVisible(true);
					frame.idle = new Controller();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 920, 640);
		setTitle("World of Idle");
		mainContainer = new JPanel();
		mainContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainContainer.setLayout(new BorderLayout(0, 0));
		setContentPane(mainContainer);
		
		// criando multiplas abas
		multiAbas = new JTabbedPane();
		panelCharacter = new JPanel();
		panelCharacter.setLayout(new GridLayout(2, 1));
		panelBag = new JPanel();
		panelPlay = new JPanel();
		panelPlay.setLayout(new GridLayout(2, 1));
		panelSettings = new JPanel();
		
		// Play tab ########################################//
		console = new JTextArea(32, 64);
		console.setFont(CONSOLE_FONT);
		console.setEditable(false);
		JScrollPane scroll = new JScrollPane(console);
		panelPlay.add(scroll);
		
		
		// Character tab ###################################//
		auxPanel = new JPanel();
		auxPanel.setLayout(new GridLayout(1,3));
		JScrollPane scrollCh = new JScrollPane(auxPanel);
		panelCharacter.add(scrollCh);
		
		JPanel below = new JPanel();
		below.setLayout(new GridLayout(1,2));
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		JLabel title1 = new JLabel("Distribuição de pontos");
		jp1.add(title1, BorderLayout.NORTH);
		below.add(jp1);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		below.add(jp2);
		panelCharacter.add(below);
		
		
		/* adding all tabs */
		multiAbas.add("Personagem", panelCharacter);
		multiAbas.add("Jogo", panelPlay);
		multiAbas.add("Mochila", panelBag);
		multiAbas.add("Config", panelSettings);
		mainContainer.add(multiAbas);
		
	}

	/* Character tab */
	static void initCharacterTab() {
		// dividido em 3 partes verticalmente
		for (int i=0; i<3; i++) {
			textArea[i] = new JTextArea();
			textArea[i].setEditable(false);
			textArea[i].setFont(INFO_FONT);
			textArea[i].setBounds(0,0, 64, 72);
			//textArea[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}

		updateCharacterInfo();
		auxPanel.add(textArea[0]);
		auxPanel.add(textArea[1]);
		auxPanel.add(textArea[2]);
	}
	
	
	
	/*
	 * public methods for interactions with classes of others packages
	 * */
	public static void print(String str) {
		console.append(str);
	}
	
	static void updateCharacterInfo() {
		textArea[0].setText("Dados do Personagem\n\n");
		textArea[0].append("Nome: \t"+ idle.HERO.getName() + "\n");
		textArea[0].append("Classe:\t"+ idle.HERO.getJOB() + "\n");
		textArea[0].append("Level:\t"+ idle.HERO.getLevel() + "\n");
		textArea[0].append("XP:\t"+ idle.HERO.getXp() + "\n");
		
		textArea[1].setText("Atributos\n\n");
		String[] attrName = idle.HERO.getAttrNames();
		int[] attr = idle.HERO.getAttributes(); 
		for (int i=0; i<6; i++)
			textArea[1].append(attrName[i] + ": \t"+ attr[i]+ "\n");
		textArea[1].append("\nHP:\t"+ idle.HERO.getHp());
		textArea[1].append("\nAtaque:\t"+ idle.HERO.getAtack());
		textArea[1].append("\nDefesa:\t"+ idle.HERO.getDefense());
		textArea[1].append("\nPower:\t"+ idle.HERO.getPower());
		
		textArea[2].setText("Equipamento\n\n");
	}
}
