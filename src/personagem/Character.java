package personagem;

import out.Console;
import util.CureSkill;
import util.Skill;

public abstract class Character {

    // Atributos comuns a todos os personagens
    protected String name;
    protected int level;
    protected long xp;
    protected int[] attributes = new int[6];
    protected final String[] attrNames = new String[6];
    //// atributos dependentes
    protected int hp;
    protected int atack;
    protected int speed;
    protected int defense;
    protected int power;
    
<<<<<<< HEAD
=======
    protected int[] attributes = new int[6];
    protected final String[] attrNames = new String[6];
    
    public Skill skills;
>>>>>>> ronald

    public Character(String name){
        this.name = name;
        this.hp = 400;
        this.xp = 0;
        this.level = 1;
        for (int i=0; i<=5; i++)
            this.attributes[i] = 100;
        this.attrNames[0] = "Força";
        this.attrNames[1] = "Destreza";
        this.attrNames[2] = "Agilidade";
        this.attrNames[3] = "Inteligência";
        this.attrNames[4] = "Sorte";
        this.attrNames[5] = "Vitalidade";
        this.power = this.atack = 100;
        
        skills = new CureSkill();
    }

    /* getters and setters */
    public String getName(){return name;}
    public String setName(String name){return this.name = name;}

    public int getLevel(){return level;}
    public int setLevel(int level){return this.level = level;}

    public long getXp(){return xp;}
    public void setXp(int xp) { this.xp = xp;}

    public int getHp(){return hp;}
    public void setHp(int hp){this.hp = hp;}
    
    public String[] getAttrNames() {return this.attrNames;}

    public int[] getAttributes(){return attributes;}

    public int getAttribute(int index){return attributes[index];}
    public int setAttribute(int index, int setAttribute){return attributes[index] = setAttribute;}

    public int getAtack() {return atack;}
    public void setAtack(int a) {this.atack = a;}

    public int getSpeed() {return speed;}
    public void setSpeed(int v) {this.speed = v;}

    public int getDefense() {return defense;}
    public void setDefense(int d) {this.defense = d;}

    public int getPower(){return power;}
    public int setPower(int p){return this.power = p;}

    /* incrementador de atributos */
    public void incrAttribute(int index, int value){
        attributes[index] += value;
    }
    

    public void showAttributes() {
        for (int i=0; i<6; i++){
            System.out.printf("[%d] %5s = %d\n", i+1, this.attrNames[i], this.attributes[i]);
        }
    }
    
    // incrementa pontos de experiencia
    public void increaseExperience(int value) {
    	this.xp += value;
    }

    // aumenta de nível:
    public void levelUp(){
        this.level++;
    	Console.levelUp(this);
    }
    
    // battle methods
    
    public int atack(Character enemy) {
    	return this.getAtack() - (int) (enemy.getDefense() / 10);
    }
}
