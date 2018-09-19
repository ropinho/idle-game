package personagem;

public class Personagem {

    // Atributos comuns a todos os personagens
    protected String nome;
    protected int hp; // saúde
    protected int xp; // experiencia
    protected int level;
    protected int[] atributos = new int[6];
    /* Atributos possui 6 espaços sendo estes disposto em:
        1 - forca, 2 - destreza, 3 - agilidade, 
        4 - inteligencia, 5 - sorte, 6 - vitalidade 
    */
    protected int poder;
    protected int skill;
   
    public Personagem(String nome){
        
        this.nome = nome;
        this.hp = 400;
        this.xp = 0;
        this.level = 1;
        this.atributos[0] = 100;
        this.atributos[1] = 100;
        this.atributos[2] = 100;
        this.atributos[3] = 100;
        this.atributos[4] = 100;
        this.atributos[5] = 100; 
        this.poder = 100;
        this.skill = 0;
    }

    /* getters and stters */
    public String getNome(){return nome;}
    public String setNome(String nome){return this.nome = nome;}
    
    public int getHp(){return hp;}
    public void setHp(int hp){this.hp = hp;}
    
    public int getXp(){return xp;}
    public int setXp(int xp){return this.xp = xp;}

    public int getLevel(){return level;}
    public int setLevel(int level){return this.level = level;}
    
    public int[] getAtributos(){return atributos;}
    public int[] setAtributos(){return atributos;}
    
    public int getAtributo(int index){return atributos[index];}
    public int setAtributo(int index, int setAttribute){return atributos[index] = setAttribute;}

    public int getPoder(){return poder;}
    public int setPoder(int poder){return this.poder = poder;}

    
    public int getSkill(){return skill;}
    public void setSkill(int skill){this.skill = skill;}
    
    
    /* incrementadores de atributos */
    public void incrAtributo(int index, int value){
        atributos[index] += value;
    }
    public void incrForca(int i){ atributos[0]+=i; }
    public void incrDestreza(int i){ atributos[1]+=i; }
    public void incrAgilidade(int i){ atributos[2]+=i; }
    public void incrInteligencia(int i){ atributos[3]+=i; }
    public void incrSorte(int i){ atributos[4]+=i; }
    public void incrVitalidade(int i){ atributos[5]+=i; }
    
    
    public int dodge(){
        return 0;
    }
    
    public int atack(){
        return 0;
    }
    
    public int defense(){
        return 0;
    }

}
