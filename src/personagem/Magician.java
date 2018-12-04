package personagem;

public class Magician extends Hero implements Job {
	
    public Magician(String name) {
        super(name);
        this.calculatePower();
        this.calculateAtack();
        this.calculateDefense();
    }
    
    
    // methods from Job
    
    @Override
    public String getJOB() { return "Mago"; }
    
    @Override
    public void calculatePower() {
    	this.power = 0;
        for (int i=0; i<6; i++){
            float peso;
            // [3] = inteligencia e [5] = vitalidade
            if(i==3 || i==5) peso = 3;
            else peso = 1;
            this.power += peso * this.attributes[i];
        }
        this.power = this.power / 10;
    }
    
    @Override
    public void calculateAtack() {
    	this.atack = 0;
        for (int i=0; i<6; i++){
            float peso;
            // [3] = inteligencia, [1] destreza e [2] = agilidade
            if(i==3 || i==1 || i==2) peso = 2;
            else peso = 1;
            this.atack += peso * this.attributes[i];
        }
        this.atack = (int) this.atack / 9;
    }

    
    @Override
    public void calculateDefense() {
    	this.defense = 0;
        for (int i=0; i<6; i++){
            float peso;
            // [3] = inteligencia e [5] = vitalidade
            if(i==3 || i==5) peso = 3;
            else peso = 1;
            this.defense += peso * this.attributes[i];
        }
        this.defense = this.defense / 10;
    }
}
