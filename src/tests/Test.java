package tests;

import java.util.Scanner;
import util.Creator;
import util.Explore;
import personagem.Hero;

public class Test {
	
  private static Scanner in;
  private static Explore exploration;

  public static void main(String args[]){
	in = new Scanner(System.in);

    // criando o personagem (Heŕoi)
	/*
    System.out.printf("\nNome do personagem: ");
    String myname = in.nextLine();
    System.out.printf("\nClasse do Herói: \n");
    System.out.printf("[a] Arrow\n[s] Swordsman\n[m] Magician\nDigite: ");
    String classechar = in.next();
    */
    Hero meuHeroi = Creator.createHero("s", "Ronaldd");

    // distribuição dos pontos de atributos iniciais = 50
    //Creator.distributePoints(50, meuHeroi);
    
    exploration = new Explore(meuHeroi);

    System.out.println("\nSeu personagem:");
    System.out.printf("Nome: %s\n", meuHeroi.getName());
    System.out.printf("Classe: %s\n", meuHeroi.getJOB() );
    meuHeroi.showAttributes();
    System.out.printf("POWER: %d\n", meuHeroi.getPower());
    System.out.printf("HP: %d\n\n", meuHeroi.getHp());

    
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
