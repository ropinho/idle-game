package util;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.media.sound.SimpleSoundbank;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.Math;
import personagem.*;
import util.Console;
import item.*;


public abstract class Creator {

    private static Scanner in;


	/* cria personagem de acordo com a classe escolhida */
    public static Hero createHero(String classe, String name) throws NullPointerException {
    	if ( classe.equals("s") || classe.equals("a") || classe.equals("m")) {
    		if (classe.equals("s")) return (new Swordsman(name));
    		if (classe.equals("a")) return (new Arrow(name));
    		if (classe.equals("m")) return (new Magician(name));
    	}
    	return null;
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
    public static Enemy generateEnemy() {
    	
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
    	int index = (int) (Math.random() * (listaDeInimigos.size()) );
    
    	return new Enemy(listaDeInimigos.get(index)[0], Integer.parseInt(listaDeInimigos.get(index)[1]));
    
    }
	
	public static Item generateEquipment() throws IOException{
		BufferedReader buff;

		Lis<String[]> listEnemy = new ArrayList<String[]>();
		String line;
		String[] data = String[6]; // Acescentar mais

		try{
			//Open archive

			buff = new BufferedReader(new FileReader("data/items.csv"));
			line = buff.readline();

			while(line != null){
				line = buff.readline();

				if(line == null) break;

				data = line.split(",");
				listEnemy.add(data);
			}

			buff.close();
		}catch(FileNotFoundException e){
			System.out.println("Erro: " + e.toString());
		}

		int index = (int) (Math.random() * (listEnemy.size()-1));
		
		return new Item(listEnemy.get(index)[0], Integer.parseInt(listEnemy.get(index)[1]), listEnemy.get(index)[2]);
	}
}
