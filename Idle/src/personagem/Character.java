package personagem;

import item.Bag;

public abstract class Character {

    // Atributos comuns a todos os personagens
    protected String name;
    protected int level;
    protected int xp;
    //// atributos dependentes
    protected int hp;
    protected int atack;
    protected int speed;
    protected int defense;
    protected int power;
    //protected Skill[] skill = new Skill[2];
    protected Bag bag;
    protected int[] attributes = new int[6];
    /*
     * Atributos possui 6 espaços sendo estes disposto em:
     * 0 - Força        (Force)
     * 1 - Destreza     (Dexterity)
     * 2 - Agilidade    (Agility)
     * 3 - Inteligencia (Intelligence)
     * 4 - Sorte        (Luck)
     * 5 - Vitalidade   (Vitality) */    
   
    public Character(String name){        
        this.name = name;
        this.hp = 400;
        this.xp = 0;
        this.level = 1;
        for (int i=0; i<=5; i++)
            this.attributes[i] = 100;
        this.power = 100;
        this.bag = new Bag(1);
        //this.skill = 0;
    }

    /* getters and stters */
    public String getName(){return name;}
    public String setName(String name){return this.name = name;}
    
    public int getLevel(){return level;}
    public int setLevel(int level){return this.level = level;}
    
    public int getXp(){return xp;}
    public int setXp(int xp){return this.xp = xp;}
    
    public int getHp(){return hp;}
    public void setHp(int hp){this.hp = hp;}
    
    public int[] getAttributes(){return attributes;}
    public int[] setAttributes(){return attributes;}
    
    public int getAttribute(int index){return attributes[index];}
    public int setAttribute(int index, int setAttribute){return attributes[index] = setAttribute;}

    public int getAtack() {return atack;}
    public void setAtack(int a) {this.atack = a;}

    public int getSpeed() {return speed;}
    public void setSpeed(int v) {this.speed = v;}

    public int getDefesa() {return defense;}
    public void setDefesa(int d) {this.defense = d;}

    public Bag getBag() {return bag;}
    public void setBag(Bag m) {this.bag = m;}
    
    public int getPower(){return power;}
    public int setPower(int p){return this.power = p;}
    
    /* incrementador de atributos */
    public void incrAtributo(int index, int value){
        attributes[index] += value;
    }
    
    // aumenta de nível:
    public void levelUp(){
        this.level++;
    }
}
