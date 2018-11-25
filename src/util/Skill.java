package util;

public abstract class Skill {

	protected SkillID identifier;
	protected int level;
	protected Skill next;
	
	public Skill (SkillID id) {
		next = null;
		identifier = id;
		level = 1;
	}
	
	public void setNext(Skill skill) {
		if (next == null) {
			next = skill;
		} else {
			next.setNext(skill);
		}
	}
	
	// verifica se a skill com o id especificado pode executar o use()
	public boolean canUse(SkillID id) {
		if (identifier == id)
			return true;
		return false;
	}
	
	public void use(SkillID id) throws Exception {
		if (canUse(id)) {
			use();
		} else {
			if (next == null)
				throw new Exception("Skill não encontrada");
			next.use(id);
		}
	}
	
	
	public abstract void use();
	
}
