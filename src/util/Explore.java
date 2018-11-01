package util;

import personagem.Enemy;

public class Explore extends java.lang.Thread {
	
	@Override
	public void run() {
		int i=0;
		Enemy enemy;
		
		while(true) {
			System.out.println("Explorando...");
			
			if (++i % 5 == 0) {
				enemy = Creator.generateEnemy();
				System.out.printf("Você encontrou um inimigo %s\nBATALHA!\n", enemy.getName());
			}
			
			try {
				Thread.sleep(600);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
			
			if (i==20) break;
		}
	}
	
	
	
}