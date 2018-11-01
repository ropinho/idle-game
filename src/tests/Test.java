package tests;

import java.util.Scanner;
import util.Creator;
import util.Explore;
import personagem.*;

public class Test {
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);

    // criando o personagem (Heŕoi)
    System.out.printf("\nNome do personagem: ");
    String myname = in.next();
    System.out.printf("\nClasse do Herói: \n");
    System.out.printf("[a] Arrow\n[s] Swordsman\n[m] Magician\nDigite: ");
    String classechar = in.next();
    Hero hero = Creator.createHero(classechar, myname);


    // distribuição dos pontos de atributos iniciais = 50
    Creator.distributePoints(50, hero);


    System.out.println("\nSeu personagem:");
    System.out.println("Nome: " + hero.getName());
    hero.showAttributes();
    System.out.printf("POWER: %d\n", hero.getPower());
    System.out.printf("HP: %d\n\n", hero.getHp());

    
    System.out.println("Iniciar jogo? [y/n]");
    String resp = in.next();
    char r = resp.charAt(0);
    
    if (r != 'y') {
    	System.out.println("Saindo do jogo\nEXIT_SUCESS");
    } else {
    	
    	new Explore().start();
    	
    }
    
    
  }
}
