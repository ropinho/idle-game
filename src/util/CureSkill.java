package util;

import out.Console;
import personagem.Character;

public class CureSkill extends Skill {
	/* Skill de Cura:
	 * Habilidade de recuperar a vida no meio da batalha */
	
	private float coef;
	
	public CureSkill() {
		super(SkillID.CURE);
		coef = 1.5f;
	}
	
	@Override
	public void use(Character c) {
		int n = (int) (c.getHp() * coef);
		Console.print("Usando Skill de Cura\tHP = ("+ c.getHp() +") => ("+ n +")");
		c.setHp(n);
	}
	
}
