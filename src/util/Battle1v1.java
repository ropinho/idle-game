package util;

import out.Console;
import personagem.Character;
import personagem.Hero;

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
		Character atk, def, aux;
	
		Console.print("BATTLE!! "+ FIGHTER_1.getName() +" VS "+ FIGHTER_2.getName());
		
		atk = FIGHTER_1; // atk = personagem atacante
		def = FIGHTER_2; // def = personagen atacado
		
		while (FIGHTER_1.getHp() > 0 && FIGHTER_2.getHp() > 0) {
			
			damage = atk.atack(def);
			def.setHp(def.getHp() - damage);
			Console.printAtackLog(atk, def, damage);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				System.err.println("ThreadSleep(): "+ ie.toString());
			}
			
			// change turns
			aux = atk;
			atk = def;
			def = aux;
		}
		
		finish();
	}
	
	@Override
	public void finish() {
		Character c = winner();
		if (c instanceof Hero) {
			((Hero) c).recalculateLevel();
		}
	}
	
	@Override
	public Character winner() {
		// checa quem terminou com o maior hp e printa no console
		Character winner = null;
		
		if (FIGHTER_1.getHp() > FIGHTER_2.getHp())
			winner = FIGHTER_1;
		else if (FIGHTER_2.getHp() > FIGHTER_1.getHp())
			winner = FIGHTER_2;
		
		return winner;
	}
	
}
