package map;

public class Map{
    String fase;
    int level;
    String classe;
    int atack;
    int def;
    int hp;
    
    public Map(String fase, int level, String classe, int atack, int def, int hp) {
        this.fase = fase;
        this.level = level;
        this.classe = classe;
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

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
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