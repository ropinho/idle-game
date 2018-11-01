package item;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import personagem.Hero;

public class Equipment {
	
	public void equiparPersonagem(Hero person){
		person.showAttributes();
		
	}	

	public void equipmentLoader() throws IOException{
		String[][] equipment = new String[3][3];
		
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
		
		for(int l=0; l<3; l++) {
			for(int j =0; j<3; j++) {
				System.out.printf("%s | ",equipment[l][j]);
			}
			System.out.println();
		}
	}
}
