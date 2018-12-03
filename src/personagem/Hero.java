package personagem;

//import item.Equipment;

public class Hero extends Character implements Job {
	
	protected int HEALTH;
	protected long EXP;
	
    public Hero(String name) {
        super(name);
        this.HEALTH = this.hp;
        this.EXP = 50;
    }
    
    // curar-se
    // voltar à saúde normal depois de uma batalha
    public void heal() {
    	this.setHp(HEALTH);
    }
    
    public void recalculateLevel() {
    	if (xp >= 2*EXP) {
    		EXP = EXP*2;
    		levelUp();
    	}
    }
    
    
    @Override
    public String getJOB() {return "";} 

	@Override
	public void calculatePower() {
		// TODO Auto-generated method stub
	}

	@Override
	public void calculateAtack() {
		// TODO Auto-generated method stub
	}

	@Override
	public void calculateDefense() {
		// TODO Auto-generated method stub
	}

}
