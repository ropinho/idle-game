package item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import personagem.Hero;

public class Equipment {
	private int[] Attribute;

	public void equiparPersonagem(Hero person){
		person.showAttributes();
		
	}	

	public void loaderEquipment(){
		String[][] equipment = new String[3][3];
		//String line;
		
		
		try {
			FileReader file = new FileReader("src/item/dados.csv");
			
			BufferedReader readFile = new BufferedReader(file);
			
			int i = 0;
			equipment[i] = readFile.readLine().split(",");
			
			while(equipment != null){
				
				for(String line : equipment[i]) {
					System.out.println(line);
				}
		
				
				System.out.println();
				i++;
				equipment[i] = readFile.readLine().split(",");
			}
			file.close();
		} catch(IOException e) {
			System.out.println("Error bixo");
		}
		
	}
}
