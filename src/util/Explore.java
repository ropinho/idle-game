package util;

import gui.PlayFrame;
import item.Item;
import out.Console;
import personagem.*;
import util.Battle1v1;
import java.lang.Math;

import map.Map;
import util.Creator;

public class Explore extends java.lang.Thread {
	
	private Hero HERO;
	private Enemy ENEMY;
	private Battle1v1 battle;
	private Map map;
	private Item items;
	
	public Explore (Hero h) {
		this.HERO = h;
	}
	
	@Override
	public void run() {
		
		int i=0;
		
		while(true) {
			map = Creator.creatorMap(HERO.getLevel()); // Inicializa a fase conforme o nivel do personagem
			//Console.printMap(map); // Printa a fase em questao e seu nivel
			
			Console.print("Fase: " + map.getFase() + " - Nivel: " + map.getLevel() + "  Explorando...");
			
			if (++i % 5 == 0) {
				
				ENEMY = Creator.generateEnemy(HERO.getLevel() + (int)Math.random()*2); // cria inimigo do nível do herói
				Console.print(HERO.getName() + " encontrou um inimigo "+ ENEMY.getName() + " level "+ ENEMY.getLevel());
				
				battle = new Battle1v1(HERO, ENEMY);
				battle.start();
				
				if (battle.winner() == HERO) {
					int n = ENEMY.getLevel(); // calcula experiencia
					int xp = 100*n + (int)1.5*n*n + 630 * (int)(Math.pow(n, 4));
					/* Encontrado em:
					 * https://www.wakfu.com/pt/forum/16-discussoes-gerais-interesse-geral/7098-
					 * como-feito-o-calculo-experiencia-necessaria-passar-nivel */

					Console.printEndOfBattle(HERO);
					Console.printIncreaseXP(xp);
					HERO.increaseExperience(xp); // ganha/incrementa XP
					
					items = Creator.generateEquipment(map.getLevel(), HERO.getJOB());
					
					Console.print("Item: " + items.getName()
							+ " \nlevel: " + items.getLevel() 
							+ "\nAtack: " + items.getAtack()
							+ "\nDefense: " + items.getDefense() 
							+ "\nHp: " + items.getHp());
					
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
