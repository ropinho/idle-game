package test;

import java.io.IOException;
import java.util.Scanner;

import item.Equipment;
import personagem.Enemy;
import personagem.Hero;
import item.Creator;


public class Test {
  public static void main(String args[]) throws IOException{
    Scanner in = new Scanner(System.in);
    
    Equipment equipment = new Equipment();
    
    equipment.equipmentLoader();
    
 
    // criando o personagem (Heŕoi)
    System.out.printf("\nNome do personagem: ");
    String myname = in.next();
    System.out.printf("\nClasse do Herói: \n");
    System.out.printf("[a] Arrow\t[s] Swordsman\t[m] Magician\nDigite: ");
    String classechar = in.next();
    Hero hero = Creator.createHero(classechar, myname); // o parametro "a" faz referencia a Arqueiro

    equipment.equipCharacter(hero, 5);
    
    hero.showAttributes();
    
    // distribuição dos pontos de atributos iniciais = 50
    Creator.distributePoints(50, hero);

    
    System.out.println("Seu personagem:");
    System.out.println("Nome: " + hero.getName());
    hero.showAttributes();
    System.out.printf("POWER: %d\n", hero.getPower());

    System.out.println("Iniciar jogo? [y/n]");
    String resp = in.next();
    char r = resp.charAt(0);
    boolean play;
    switch (r) {
      case 'y':
        play = true; break;
      case 'n':
        play = false; break;
    }

    /*
    int i=1;
    while (i < 6) {
      Enemy inimigo = new Enemy("Troll", 2);
      System.out.printf("(%d) %s encontra %s\n", i, hero.getName(), inimigo.getName());

   
    }
    */  
  }
}
