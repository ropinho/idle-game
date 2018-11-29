package util;

import personagem.Character;

public class CureSkill extends Skill {
	/* Skill de Cura:
	 * Habilidade de recuperar a vida no meio da batalha */
	
	public CureSkill() {
		super(SkillID.CURE);
	}
	
	@Override
	public void use(Character c) {
		int n = (int) (c.getHp() * 1.5);
		System.out.printf("Usando Skill de Cura\tHP = (%d) => (%d)\n", c.getHp(), n);
		c.setHp(n);
	}
	
}
