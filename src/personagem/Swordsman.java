package personagem;

public class Swordsman extends Hero implements Job {
    
    public Swordsman(String name) {
        super(name);
        this.calculatePower();
        this.calculateAtack();
    }
    
    
    // methods from Job
    
    @Override
    public String getJOB() { return "Espadachim"; }
    
    @Override
    public void calculatePower() {
    	this.power = 0;
    	float peso;
        for (int i=0; i<6; i++){
            // [0] = força e [2] = agilidade
            if(i==0 || i==2) peso = 3;
            else peso = 1;
            this.power += peso * this.attributes[i];
        }
        this.power = this.power / 10;
    }
    
    @Override
    public void calculateAtack() {
    	this.atack = 0;
        float peso;
        for (int i=0; i<6; i++){
            // [0] = força, [1] destreza e [2] = agilidade
            if(i==0 || i==1 || i==2) peso = 2;
            else peso = 1;
            this.atack += peso * this.attributes[i];
        }
        this.atack = (int) this.atack / 9;
    }
}
