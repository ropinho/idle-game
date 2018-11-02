package util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import personagem.*;

public abstract class Creator {

    // cria personagem de acordo com a classe escolhida
    // (!) Atenção para NullPointerException em caso de classe ser diferente de
    // dos 3 caracteres disponíveis
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
    	
    	Reader reader = Files.newBufferedReader(Paths.get("resources/enemies.csv"));
    	CSVReader csvreader = new CSVReaderBuilder(reader).withSkipLines(1).build();
    	System.out.println("Obj CSVReader e CSVReaderBuilder");
    	
    	List<String[]> enemies = csvreader.readAll();
    	System.out.println("Lista criada");
    	
    	for (String[] enemy : enemies) {
    		System.out.printf("Nome: %s\tNivel: %s\n", enemy[0], enemy[1]);
    	}
    	
    	return new Enemy("Ogro de Lama", 1);
    }
    
    
}
