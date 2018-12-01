package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class Play extends JFrame {

	private JPanel mainContainer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play();
					frame.setVisible(true);
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
		mainContainer = new JPanel();
		mainContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainContainer.setLayout(new BorderLayout(0, 0));
		setContentPane(mainContainer);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		mainContainer.add(toolBar, BorderLayout.NORTH);
		
		JButton btnCriarPersonagem = new JButton("Criar Personagem");
		toolBar.add(btnCriarPersonagem);
		
		JButton btnMochila = new JButton("Mochila");
		toolBar.add(btnMochila);
		
		JButton btnNewButton = new JButton("New button");
		toolBar.add(btnNewButton);
	}

}
