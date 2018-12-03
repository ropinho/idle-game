package tests;

import java.util.Scanner;

import util.Console;
import util.Creator;
import util.Explore;
import personagem.*;


import item.Item;


public class Test {
	
  private static Scanner in;
  private static Explore exploration;
  private static Hero meuHeroi;
  private static Item Equip;

  public static void main(String args[]){
	  in = new Scanner(System.in);

    meuHeroi = Creator.createHero("s", "Aluisio Lee");
    exploration = new Explore(meuHeroi);

    Console.printAllCharacterInfo(meuHeroi);

    Equip = Creator.generateEquipment("s");
    Console.printEquip(Equip);
    

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
