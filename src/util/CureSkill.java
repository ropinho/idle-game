package util;

public class CureSkill extends Skill {
	/* Skill de Cura:
	 * Habilidade de recuperar a vida no meio da batalha */
	
	public CureSkill() {
		super(SkillID.cure);
	}
	
	@Override
	public void use() {
		System.out.println("Você usou uma Skill de Cura");
	}
	
}
