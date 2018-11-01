package item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
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
		
		
		Reader equipment = Files.newBufferedReader(Paths.get("src/item/dados.csv"));
		
		CSVReader csvReader = new CSVReaderBuilder(equipment).withSkipLines(1).build();
		
		pessoas = (ArrayList<String[]>) csvReader.readAll();
		
		int i =0;
		for(String[] pessoa : pessoas) {
			System.out.println(pessoa[i]);
			i++;
		}
		
		
		/*
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
