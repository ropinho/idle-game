package item;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import personagem.Hero;

public class Equipment {
	private String[][] equipment = new String[3][4];
	
	public void equipCharacter(Hero hero, int level){
		
		Random random = new Random();
		
		int[] optionsEquip = new int[3]; // armazena o indices dos esquipamentos condizentes com o lvl
		
		int set = 1; //Condicao para continuar
		
		
		for(int i=0; i<3; i++){
			
			//Converte a string em int
			int equipLevel = Integer.parseInt(equipment[i][1]);
			
			
			/*Verifica se o nivel do personagem e o mesmo do equip
			 * se for o mesmo nivel armazena o indice daquele equip
			 * */
			if(level == equipLevel) {
				optionsEquip[i] = i;
				set = 0;
			}
		}
		if(set == 0) {
			int index = random.nextInt(3);
			int k = 0;
			
			for(int i=2; i<4; i++){
				hero.incrAttribute(k, Integer.parseInt(equipment[index][i]));
				k++;
			}
			/*
			System.out.println("\nSou personagem foi equipado com\n -> " + equipment[index][0]
					+ "\n -> Lvl: " + equipment[index][1]
					+ "\n -> Atack: " + equipment[index][2] 
					+ "\n -> Def: " + equipment[index][3]
					);
			*/
			
			// chamar metodo showSetEquipment(index);
		}
			
		
	}	

	
	public void equipmentLoader() throws IOException{
			
		File file = new File("src/item/dados.csv");
		
		try {
			String line = new String();
			Scanner leitor = new Scanner(file);
			
			int i =0;
			while(leitor.hasNext()) {
				line = leitor.nextLine();
				equipment[i] = line.split(",");
				i++;
			}
		} catch(FileNotFoundException e){
			System.out.println("Erro ao ler o arquivo");
		}
	}

	
	public void showSetEquipment(int index) {
		String[][] Showequipment = new String[5][4];
		
		
	}

}
