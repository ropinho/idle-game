package util;

import personagem.Character;

public class DamageSkill extends Skill {
	/* Skill de Dano:
	 * Habilidade de aumentar o dano do golpe em uma batalha */
	
	public DamageSkill() {
		super(SkillID.DAMAGE);
	}

	@Override
	public void use(Character c) {
		
	}
}
