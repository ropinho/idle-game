package map;

public class Map{
    String fase;
    int level;
    int atack;
    int def;
    int hp;
    
    public Map(String fase, int level, int atack, int def, int hp) {
        this.fase = fase;
        this.level = level;
        this.atack = atack;
        this.def = def;
        this.hp = hp;
    }

	public String getFase() {
        return this.fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAtack() {
        return this.atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}