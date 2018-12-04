package personagem;

public class Arrow extends Hero {
    
    public Arrow(String name) {
        super(name);
        this.calculatePower();
        this.calculateAtack();
        this.calculateDefense();
    }
    
    
    // methods from Job
    
    @Override
    public String getJOB() { return "Arqueiro"; }
    
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
    
    @Override
    public void calculateAtack() {
    	this.atack = 0;
        for (int i=0; i<6; i++){
            float peso;
            // [3] = inteligencia, [2] agilidade e [4] = sorte
            if(i==2 || i==3 || i==4) peso = 2;
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
            // [3] = inteligencia, [2] agilidade e [4] = sorte
            if(i==2 || i==3 || i==4) peso = 2;
            else peso = 1;
            this.atack += peso * this.attributes[i];
        }
        this.atack = (int) this.atack / 9;
    }

}
