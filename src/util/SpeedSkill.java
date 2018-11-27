package util;

import personagem.Character;

public class SpeedSkill extends Skill {
	/* Skill de velocidade:
	 * Habilidade de aumentar a velocidade, ou seja, o intervalo
	 * entre um ataque e outro na batalha */

	public SpeedSkill() {
		super(SkillID.SPEED);
	}
	
	@Override
	public void use(Character c) {
		System.out.println("Você usou uma Skill de Velocidade");
	}
}
