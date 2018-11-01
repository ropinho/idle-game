package personagem;

public class Swordsman extends Hero implements Job {
    
    public Swordsman(String name) {
        super(name);
        this.calculatePower();
    }
    
    
    // methods from Job
    
    @Override
    public void calculatePower() {
    	this.power = 0;
        for (int i=0; i<6; i++){
            float peso;
            // [0] = força e [2] = agilidade
            if(i==0 || i==2) peso = 3;
            else peso = 1;
            
            this.power += peso * this.attributes[i];
        }
        this.power = this.power / 10;
    }
}
