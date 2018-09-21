package item;

/*
 * A idéia é que a Mochila possa ser expandida de acordo com
 * a mudança de nivel (evolução), daí */
public class Mochila {
    protected int level;
    protected int size;
    protected Item[] itens;

    public Mochila(int level){
        this.level = level;
        this.size = (int) (14 + java.lang.Math.pow(2, level)); // size = 14 + 2^level
        this.itens = new Item[this.size];
    }

    /* setters and getters */
    
    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}

    public int getSize() {return size;}
    public void setSize(int size) {this.size = size;}

    public Item[] getItens() {return itens;}
    public void setItens(Item[] itens) {this.itens = itens;}
    
    /* **** **/
    
    public void levelUp() {
        this.level++;
    }
    
}
