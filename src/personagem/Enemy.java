package personagem;

public class Enemy extends Character {
    
    public Enemy(String name) {
        super(name);
        // teste: dando valores em ataque e defesa para testes
        this.atack = this.defense = this.power; 
    }

    public Enemy(String name, int lvl) {
        super(name);
        this.level = lvl;
        this.atack = lvl * 20;
        this.hp = (int)( this.hp + lvl*10 );
    }
}
