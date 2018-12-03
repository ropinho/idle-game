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
			
			if (++i % 5 == 0) {
				ENEMY = Creator.generateEnemy(HERO.getLevel() + (int)Math.random()*2); // cria inimigo do nível do herói
				Console.print(HERO.getName() + " encontrou um inimigo "+ ENEMY.getName() + " level "+ ENEMY.getLevel());
				
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
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
		}
	}
}
