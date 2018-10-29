package personagem;

public class Arrow extends Hero {
    
    public Arrow(String name) {
        super(name);
        // calcula o valor do power
        // peso 3, para destreza(1) e sorte(4)
        this.power = 0;
        for (int i=0; i<6; i++){
            float peso=1;
            if(i==1 || i==4) peso = 3;
            this.power += peso * this.attributes[i];
        }
        this.power = this.power / 10;
    }
    
}
