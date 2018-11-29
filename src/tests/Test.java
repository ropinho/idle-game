package tests;

import java.util.Scanner;

import util.Console;
import util.Creator;
import util.Explore;
import personagem.*;

public class Test {
	
  private static Scanner in;
  private static Explore exploration;
  private static Hero meuHeroi;

  public static void main(String args[]){
	in = new Scanner(System.in);

    meuHeroi = Creator.createHero("s", "Aluisio Lee");
    exploration = new Explore(meuHeroi);

    Console.printAllCharacterInfo(meuHeroi);

    System.out.println("Iniciar jogo? [y/n]");
    String resp = in.next();
    char r = resp.charAt(0);
    
    if (r != 'y') {
    	System.out.println("Encerrando o jogo");
    } else {
    	exploration.start();
    }
    
  }
}
