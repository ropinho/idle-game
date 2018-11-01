package item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
//import com.sun.java.util.jar.pack.Package.File;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import personagem.Hero;

public class Equipment {
	private int[] Attribute;
	ArrayList<String[]> pessoas;

	public void equiparPersonagem(Hero person){
		person.showAttributes();
		
	}	

	public void loaderEquipment() throws IOException{
		//String[][] equipment = new String[3][3];
		//String line;
		
		File arquivo = new File("src/item/dados.csv");
		
		try {
			String line = new String();
			Scanner leitor = new Scanner(arquivo);
			String[][] lineUndescor = new String[3][3];
			int i =0;
			while(leitor.hasNext()) {
				line = leitor.nextLine();
				
				lineUndescor[i] = line.split(",");
				
				i++;
			}
			for(int l=0; l<3; l++) {
				for(int j =0; j<3; j++) {
					System.out.printf("%s | ",lineUndescor[l][j]);
				}
				System.out.println();
			}
		} catch(FileNotFoundException e){
			
		}
		
		
		
		
		
		
		//Metodo lendo com o openCSV
		/*
		Reader equipment = Files.newBufferedReader(Paths.get("src/item/dados.csv"));
		
		CSVReader csvReader = new CSVReaderBuilder(equipment).withSkipLines(1).build();
		
		pessoas = (ArrayList<String[]>) csvReader.readAll();
		
		int i =0;
		for(String[] pessoa : pessoas) {
			System.out.println(pessoa[i]);
			i++;
		}
		*/
		
		
		
		/*
		//Metodo Normal de leitura
		
		try {
			FileReader file = new FileReader("src/item/dados.csv");
			
			BufferedReader readFile = new BufferedReader(file);
			
			int i = 0;
			equipment[i] = readFile.readLine().split(",");
			
			while(equipment != null){
				
				for(String line : equipment[i]) {
					System.out.println(line);
				}
				i++;
				equipment[i] = readFile.readLine().split(",");
			}
			file.close();
			
		} catch(IOException e) {
			System.out.println("Error na abertura do arquivo");
		}
		*/
		
		
		
	}
}
