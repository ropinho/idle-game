package util;

import gui.PlayFrame;
import out.Console;
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
			Console.print("Explorando...");
			
			if (++i % 4 == 0) {
				ENEMY = Creator.generateEnemy();
				Console.print(HERO.getName() + " encontrou um inimigo "+ ENEMY.getName());
				
				battle = new Battle1v1(HERO, ENEMY);
				battle.start();
				
				if (battle.winner() == HERO) {
					Console.printEndOfBattle(HERO);
					Console.printIncreaseXP( HERO.getHp() + ENEMY.getLevel() );
					HERO.increaseExperience( HERO.getHp() + ENEMY.getLevel() ); // ganha/incrementa XP
					HERO.heal(); // recupera HP
					PlayFrame.idle.updateCharacterInfo();// atualiza aba de info do person.
				} else {
					Console.printEndOfBattle(ENEMY);
					Console.printGameOver();
					Console.printAllCharacterInfo(HERO);
					break;
				}
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
		}
	}


}