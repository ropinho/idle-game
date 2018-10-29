package util;

import personagem.*;
import java.util.Scanner;

public abstract class Creator {

    // cria personagem de acordo com a classe escolhida
    // (!) Atenção para NullPointerException em caso de classe ser diferente de
    // dos 3 caracteres disponíveis
    public static Hero createHero(String classe, String name) {
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
        hero.showAttributes();
        System.out.printf("Atributo: "); int aIndex = in.nextInt();
        System.out.printf("Valor: "); int value = in.nextInt();
        if (points-value >= 0){
          hero.incrAttribute(aIndex-1, value);
          points = points - value;
        } else {
          hero.incrAttribute(aIndex-1, points);
          points = 0;
        }
      }
    }


    public static Enemy generateEnemy(int level) {
        return new Enemy("Troll", level);
    }
}
