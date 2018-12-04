package personagem;

import out.Console;

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
    	if (xp >= EXP + 2*EXP) {
    		EXP += EXP*2;
    		levelUp();
    	}
    }
    
    @Override
    public void recalculateHP() {
    	// hp x vitalidade
    	this.hp = (int)(hp * attributes[5])/100;
    	this.HEALTH = this.hp;
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
	
	@Override
	public void levelUp() {
		/* Incrementa o level e
    	 * aumenta em 10% cada atributo independente */
        this.level++;
        for (int i=0; i<6; i++) {
        	attributes[i] += (int) (attributes[i] / 10);
        }
        recalculateHP();
        calculateAtack();
        calculateDefense();
        calculatePower();
        Console.updateCharacterInfo();
    	Console.levelUp(this);
	}

}
