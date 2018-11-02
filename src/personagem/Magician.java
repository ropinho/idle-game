package personagem;

public class Magician extends Hero implements Job {
    
    public Magician(String name) {
        super(name);
        this.calculatePower();
    }
    
    
    // methods from Job
    
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
}
