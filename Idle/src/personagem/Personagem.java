package personagem;

import item.Mochila;

public class Personagem {

    // Atributos comuns a todos os personagens
    protected String nome;
    protected int level;
    protected int xp;
    //// atributos dependentes
    protected int hp;
    protected int ataque;
    protected int velocidade;
    protected int defesa;
    protected int vigor;
    protected int poder;
    //protected Skill[] skill = new Skill[2];
    protected Mochila bolsa;
    protected int[] atributos = new int[6];
    /*
     * Atributos possui 6 espaços sendo estes disposto em:
     * 0 - Força        (Force)
     * 1 - Destreza     (Dexterity)
     * 2 - Agilidade    (Agility)
     * 3 - Inteligencia (Intelligence)
     * 4 - Sorte        (Luck)
     * 5 - Vitalidade   (Vitality) */    
   
    public Personagem(String nome){        
        this.nome = nome;
        this.hp = 400;
        this.xp = 0;
        this.level = 1;
        for (int i=0; i<=5; i++)
            this.atributos[i] = 100;
        this.poder = 100;
        this.bolsa = new Mochila(1);
        //this.skill = 0;
    }

    /* getters and stters */
    public String getNome(){return nome;}
    public String setNome(String nome){return this.nome = nome;}
    
    public int getLevel(){return level;}
    public int setLevel(int level){return this.level = level;}
    
    public int getXp(){return xp;}
    public int setXp(int xp){return this.xp = xp;}
    
    public int getHp(){return hp;}
    public void setHp(int hp){this.hp = hp;}
    
    public int[] getAtributos(){return atributos;}
    public int[] setAtributos(){return atributos;}
    
    public int getAtributo(int index){return atributos[index];}
    public int setAtributo(int index, int setAttribute){return atributos[index] = setAttribute;}

    public int getAtaque() {return ataque;}
    public void setAtaque(int a) {this.ataque = a;}

    public int getVelocidade() {return velocidade;}
    public void setVelocidade(int v) {this.velocidade = v;}

    public int getDefesa() {return defesa;}
    public void setDefesa(int d) {this.defesa = d;}

    public int getVigor() {return vigor;}
    public void setVigor(int v) {this.vigor = v;}

    public Mochila getBolsa() {return bolsa;}
    public void setBolsa(Mochila m) {this.bolsa = m;}
    
    public int getPoder(){return poder;}
    public int setPoder(int poder){return this.poder = poder;}
    
    //public int getSkill(){return skill;}
    //public void setSkill(int skill){this.skill = skill;}
    
    /* incrementador de atributos */
    public void incrAtributo(int index, int value){
        atributos[index] += value;
    }
    
    // aumenta de nível:
    public void levelUp(){
        this.level++;
    }
    
    public int dodge(){
        return 0;
    }
    
    public int atack(){
        return 0;
    }
    
    public int receiveAtack(){
        return 0;
    }

}
