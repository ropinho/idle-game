package util;

import java.io.IOException;
import personagem.*;
import util.Battle1v1;

public class Explore extends java.lang.Thread {
	
	private Hero HERO;
	
	public Explore (Hero h) {
		this.HERO = h;
	}
	
	@Override
	public void run() {
		int i=0;
		Enemy enemy;
		
		while(true) {
			System.out.print("Explorando...\n");
			
			if (++i % 3 == 0) {
				try {
					enemy = Creator.generateEnemy();
					System.out.printf("%s encontrou um inimigo %s\n", HERO.getName(), enemy.getName());
					
					new Battle1v1(HERO, enemy).start();
					
				} catch (IOException ioe) {
					System.out.printf("Impossivel gerar inimigo: %s", ioe.toString());
				}
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
			
			if (i==10) break;
		}
	}
	
	
	
}