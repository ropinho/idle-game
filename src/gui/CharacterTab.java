package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CharacterTab extends JPanel {
	
	JPanel box[] = new JPanel[2];
	
	JLabel titulo[] = new JLabel[2];
	JPanel intern[] = new JPanel[2];
	JLabel labels[] = new JLabel[6];
	JTextField fields[] =  new JTextField[6];
	JPanel buttonArea;
	JButton btnSubmit[] = new JButton[2];
	
	public CharacterTab() {
		initComponents();
		setLayout(new GridLayout(1,2));
		add(box[0]);
		add(box[1]);
		
		addFunctionOfButton();
	}
	
	private void initComponents() {
		
		String[] titulos = {"Distribuir pontos: "+ PlayFrame.idle.pointsToDistrib, "Equipar"};
		
		for (int i=0; i<2; i++) {
			box[i] = new JPanel(new BorderLayout());
			titulo[i] = new JLabel(titulos[i]);
			box[i].add(titulo[i], BorderLayout.NORTH);
			intern[i] = new JPanel();
			intern[i].setLayout(new GridLayout(8, 2));
		}
		
		for (int i=0; i<6; i++) {
			labels[i] = new JLabel(PlayFrame.idle.HERO.getAttrNames()[i]);
			intern[0].add(labels[i]);
			fields[i] = new JTextField();
			fields[i].setText("0");
			intern[0].add(fields[i]);
		}
		
		for (int i=0; i<2; i++) {
			box[i].add(intern[i], BorderLayout.CENTER);
			buttonArea = new JPanel();
			btnSubmit[i] = new JButton("OK");
			buttonArea.add(btnSubmit[i]);
			box[i].add(buttonArea, BorderLayout.SOUTH);
		}
		
	}
	
	
	private void addFunctionOfButton() {
		btnSubmit[0].addActionListener(new ActionListener() {
			/*
			 * Função de atualizar os pontos de atributos de acordo
			 * com os valores diigitados nos campos
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int attrIncrementados[] = new int[6];
				int soma = 0;
				String txt;
				
				for (int i=0; i<6; i++) {
					txt = fields[i].getText();
					attrIncrementados[i] = Integer.parseInt(txt);
					soma += attrIncrementados[i];
				}
				
				// verificar se a soma deles é menor que o disponivel
				if (soma <= PlayFrame.idle.pointsToDistrib) {
					// incrementa atributos
					for (int i=0; i<6; i++) {
						PlayFrame.idle.HERO.incrAttribute(i, attrIncrementados[i]);
					}

					PlayFrame.idle.pointsToDistrib = PlayFrame.idle.pointsToDistrib - soma;
					System.out.printf("Incrementando os atributos: SOMA = %d", soma);
					titulo[0].setText("Distribuir pontos: "+ PlayFrame.idle.pointsToDistrib);
					PlayFrame.idle.HERO.calculateAtack();
					PlayFrame.idle.HERO.calculateDefense();
					PlayFrame.idle.HERO.calculatePower();
					PlayFrame.updateCharacterInfo();
					
				}
			}
		});
	}
	
}
