package util;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
import personagem.*;

public abstract class Creator {

    /* cria personagem de acordo com a classe escolhida */
    public static Hero createHero(String classe, String name) throws NullPointerException {
        if (classe.equals("s")) return (new Swordsman(name));
        if (classe.equals("a")) return (new Arrow(name));
        if (classe.equals("m")) return (new Magician(name));

        System.out.println("Error on Create Hero: Class not exists!");
        return null;
    }


    public static void distributePoints(int points, Hero hero) {
      Scanner in = new Scanner(System.in);
      while (points > 0) {
        System.out.printf("\nVocê ainda possui %d pontos de atributos para distribuir.\n", points);
        System.out.printf("Digite o valor para incrementar e em seguida o atributo:\n");
        System.out.printf ("--- POWER = %d", hero.getPower());
        System.out.println("[0] Cancelar operação");
        hero.showAttributes();
        System.out.printf("Atributo: "); int aIndex = in.nextInt();
        System.out.printf("Valor: "); int value = in.nextInt();
        if (aIndex > 0 && value > 0) {
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
      }
    }

    
    /*
     * Gerar um inimigo randomicamente a partir de um arquivo
     */
    public static Enemy generateEnemy() throws IOException {
    	
    	BufferedReader buff;
    	Enemy inimigo;
    	List<String[]> listaDeInimigos = new ArrayList<String[]>();
    	String linha;
    	String[] dados =  new String[2];
    	
    	try {
    		// abrir arquivo
    		buff = new BufferedReader(new FileReader("src/resources/enemies.csv"));
    		
    		linha = buff.readLine();
    		
    		 while (linha != null) {
    			linha = buff.readLine();
    			if (linha == null) break;
    			dados = linha.split(",");
    			listaDeInimigos.add(dados);
    		}
    		
    		buff.close();
    		
    	} catch (FileNotFoundException e) {
    		System.out.printf("Erro: %s", e.toString());
    	}
    	
    	// pega um valor aleatorio dentro do escopo do tamanho da lista
    	int index = 1 + (int) (Math.random() * (listaDeInimigos.size()-1) );
    
    	inimigo = new Enemy(listaDeInimigos.get(index)[0], Integer.parseInt(listaDeInimigos.get(index)[1]));
    	
    	return inimigo;
    }
    
    
}
