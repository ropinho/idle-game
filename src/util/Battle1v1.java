package util;

import personagem.Character;

public class Battle1v1 implements Battle {

	private final Character FIGHTER_1;
	private final Character FIGHTER_2;
	
	public Battle1v1(Character c1, Character c2) {
		this.FIGHTER_1 = c1;
		this.FIGHTER_2 = c2;
	}
	
	@Override
	public void start() {
		int damage;
		Character atacante, atacado;
		
		System.out.printf("BATTLE!! %s VS %s \n", FIGHTER_1.getName(), FIGHTER_2.getName());
		while (FIGHTER_1.getHp() > 0 && FIGHTER_2.getHp() > 0) {
			
			try {
				damage = FIGHTER_1.atack(FIGHTER_2);
				FIGHTER_2.setHp(FIGHTER_2.getHp() -damage);
				System.out.printf("%s(%d) causou %d de dano em %s(%d)\n", FIGHTER_1.getName(), FIGHTER_1.getHp(),damage, FIGHTER_2.getName(), FIGHTER_2.getHp());
				
				Thread.sleep(1000);
				
				damage = FIGHTER_2.atack(FIGHTER_1);
				FIGHTER_1.setHp(FIGHTER_1.getHp() -damage);
				System.out.printf("%s(%d) causou %d de dano em %s(%d)\n", FIGHTER_2.getName(), FIGHTER_2.getHp(),damage, FIGHTER_1.getName(), FIGHTER_1.getHp());
				
				Thread.sleep(1000);
				
			} catch (InterruptedException ie) {
				System.err.println(ie.toString());
			}
		}
	}
	
	
	@Override
	public void finish() {
		
	}
	
}
