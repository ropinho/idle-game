package util;

public class DamageSkill extends Skill {
	/* Skill de Dano:
	 * Habilidade de aumentar o dano do golpe em uma batalha */
	
	public DamageSkill() {
		super(SkillID.damage);
	}

	@Override
	public void use() {
		System.out.println("Você usou uma Skill de Dano");
	}
}
