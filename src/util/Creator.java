package util;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import out.Console;
import java.lang.Math;
import personagem.*;
import item.*;
import map.Map;

public abstract class Creator {

    private static Scanner in;


	/* cria personagem de acordo com a classe escolhida */
    public static Hero createHero(String classe, String name) throws NullPointerException {
    	if ( classe.equals("s") || classe.equals("a") || classe.equals("m")) {
    		if (classe.equals("s")) return (new Swordsman(name));
    		if (classe.equals("a")) return (new Arrow(name));
    		if (classe.equals("m")) return (new Magician(name));
		}
		
    	throw new NullPointerException();
    }

    public static void distributePoints(int points, Hero hero) {
      in = new Scanner(System.in);
      while (points > 0) {
        System.out.printf("\nVocê ainda possui %d pontos de atributos para distribuir.\n", points);
        System.out.printf("Digite o indice do atributo para incrementar e em seguida o valor:\n");
        System.out.println("\n[0] Cancelar operação");
        Console.printAttributesOf(hero);
        System.out.printf("Atributo: "); int aIndex = in.nextInt();
        if (aIndex > 0) {
        	System.out.printf("Valor: "); int value = in.nextInt();
        	if (value > 0) {
        		if (points-value >= 0){
        			hero.incrAttribute(aIndex-1, value);
        			points = points - value;
        		} else {
        			hero.incrAttribute(aIndex-1, points);
        			points = 0;
        		}
        		hero.calculatePower();
        	} else {
        		break;
        	}
        } else {
        	if (aIndex == 0) break;
        	else continue;
        }
      }
    }

    /*
     * Gerar um inimigo randomicamente a partir de um arquivo
     */
    public static Enemy generateEnemy(int level) {
    	
    	BufferedReader buff;
    	List<String[]> listaDeInimigos = new ArrayList<String[]>();
    	String linha;
    	String[] dados =  new String[2];
    	
    	try {
    		// abre o arquivo
    		buff = new BufferedReader(new FileReader("data/enemies.csv"));
    		// lê a primeira linha, essa linha é de cabeçalho e é ignorada
    		linha = buff.readLine();
    		
    		while (linha != null) {
    			linha = buff.readLine();
    			if (linha == null) break;
    			dados = linha.split(",");
    			listaDeInimigos.add(dados);
    		}
    		
    		buff.close();
    		
    	} catch (IOException e) {
    		System.out.printf("Erro: %s", e.toString());
    	}
    	
    	// pega um valor aleatorio dentro do escopo do tamanho da lista
    	int index = (int) ( Math.random() * (listaDeInimigos.size()) );
    
    	return new Enemy(listaDeInimigos.get(index)[0], level);
    
    }
	
	public static Item generateEquipment(int level, String characterClass){
		BufferedReader buff;

		List<String[]> listEquipment = new ArrayList<String[]>();
		String line;
		String[] data = new String[7]; //Separação das String

		try{
			//Open archive
			buff = new BufferedReader(new FileReader("data/items.csv"));
			line = buff.readLine();
			
			while(line != null){
				line = buff.readLine();

				if(line == null) break;

				data = line.split(",");
				
				//Level seria da fase que ele está e não do personagem
				if(level > Integer.parseInt(data[1])) // Verifica se o level da fase é maior que o level do item
					if(characterClass.equals(data[2])  || "x" == data[2]) listEquipment.add(data); //Verifica se o item é da classe do personagem ou se é uma poção
			}

			buff.close();
		}catch(IOException e){
			System.out.printf("Erro: %s", e.toString());
		}
		
		int index = (int) (Math.random() * (listEquipment.size()));
		
		//Retorna todos os parametrôs com, item, level, peso, class, atack, def e hp
		return new Item(listEquipment.get(index)[0], 
						Integer.parseInt(listEquipment.get(index)[1]),
						listEquipment.get(index)[2],
						Float.parseFloat(listEquipment.get(index)[3]),
						Integer.parseInt(listEquipment.get(index)[4]), 
						Integer.parseInt(listEquipment.get(index)[5]),
						Integer.parseInt(listEquipment.get(index)[6]) );
	} 

	public static Map creatorMap(int level, String characterClass){
		BufferedReader buff;
	
		String line;
		String[] data = new String[6]; //Separação das String
	
		try{
			//Open archive
			buff = new BufferedReader(new FileReader("data/maps.csv"));
			line = buff.readLine();
			
			while(line != null){
				line = buff.readLine();
	
				if(line == null) break;
	
				data = line.split(",");
				
				if(level < Integer.parseInt(data[1].intern()))	break; 
			}
	
			buff.close();
		}catch(IOException e){
			System.out.printf("Erro: %s", e.toString());
		}
	
		return new Map(data[0], Integer.parseInt(data[1]) , data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[1])); 
	}
}
