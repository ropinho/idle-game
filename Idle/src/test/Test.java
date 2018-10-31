package test;

import personagem.Enemy;
import personagem.Hero;
import util.Creator;


public class Test {
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    
    Equipment test = new Equipment();
   
    // criando o personagem (Heŕoi)
    System.out.printf("\nNome do personagem: ");
    String myname = in.next();
    System.out.printf("\nClasse do Herói: \n");
    System.out.printf("[a] Arrow\t[s] Swordsman\t[m] Magician\nDigite: ");
    String classechar = in.next();
    Hero hero = Creator.createHero(classechar, myname); // o parametro "a" faz referencia a Arqueiro

    test.equiparPersonagem(hero);
    
    
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
