package util;

import java.io.IOException;
import personagem.*;
import util.Battle1v1;

public class Explore extends java.lang.Thread {
	
	private Hero HERO;
	private Enemy ENEMY;
	private Battle1v1 battle;
	
	public Explore (Hero h) {
		this.HERO = h;
	}
	
	@Override
	public void run() {
		int i=0;
		
		while(true) {
			System.out.print("Explorando...\n");
			
			if (++i % 3 == 0) {
				try {
					ENEMY = Creator.generateEnemy();
					System.out.printf("%s encontrou um inimigo %s\n", HERO.getName(), ENEMY.getName());
					
					battle = new Battle1v1(HERO, ENEMY);
					battle.start();
					
					if (battle.winner() == HERO) {
						Console.printEndOfBattle(HERO);
						HERO.heal();
					} else {
						Console.printEndOfBattle(ENEMY);
						Console.printGameOver();
						break;
					}
					
				} catch (IOException ioe) {
					System.err.printf("Impossivel gerar inimigo: %s", ioe.toString());
				}
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
			
			if (i==50) break;
		}
	}


}