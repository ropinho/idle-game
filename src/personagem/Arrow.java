package personagem;

public class Arrow extends Hero implements Job {
    
    public Arrow(String name) {
        super(name);
        this.calculatePower();
    }
    
    
    // methods from Job
    
    @Override
    public void calculatePower() {
    	this.power = 0;
        for (int i=0; i<6; i++){
            float peso;
            // [1] = destreza e [4] = sorte
            if(i==1 || i==4) peso = 3;
            else peso = 1;
            
            this.power += peso * this.attributes[i];
        }
        this.power = this.power / 10;
    }
}
