package personagem;

public class Enemy extends Character {
    
    public Enemy(String name) {
        super(name);
    }

    public Enemy(String name, int lvl) {
        super(name);
        this.level = lvl;
        
    }
}
