package util;

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
		int damage, cureskill=1;
		Character atk, def, aux;
		
		System.out.printf("BATTLE!! %s VS %s \n", FIGHTER_1.getName(), FIGHTER_2.getName());
		
		atk = FIGHTER_1; // atk = personagem atacante
		def = FIGHTER_2; // def = personagen atacado
		
		while (FIGHTER_1.getHp() > 0 && FIGHTER_2.getHp() > 0) {
			
			/* Test of skill of cure */
			if (def instanceof Hero  &&  def.getHp() <= 200 && cureskill > 0) {
				try {
					def.skills.use(def, SkillID.CURE);
					cureskill--;
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			
			damage = atk.atack(def);
			def.setHp(def.getHp() - damage);
			Console.printAtackLog(atk, def, damage);
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException ie) {
				System.err.println(ie.toString());
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
