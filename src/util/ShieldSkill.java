package util;

import personagem.Character;

public class ShieldSkill extends Skill {
	/* Skill de escudo:
	 * Habilidade de criar uma proteção que diminui os danos
	 * recebidos em uma batalha enquanto ativada */
	
	public ShieldSkill() {
		super(SkillID.SHIELD);
	}
	
	@Override
	public void use(Character c) {
		System.out.println("Você usou uma Skill de Proteção");
	}

}
