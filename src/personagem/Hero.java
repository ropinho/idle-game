package personagem;

//import item.Equipment;

public class Hero extends Character implements Job {
	
	protected int HEALTH;
	
    public Hero(String name) {
        super(name);
        this.HEALTH = this.hp;
    }
    
    // curar-se
    // voltar à saúde normal depois de uma batalha
    public void heal() {
    	this.setHp(HEALTH);
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
