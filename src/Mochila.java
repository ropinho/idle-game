import idle.item.Item;
/*
 * A idéia é que a Mochila possa ser expandida de acordo com
 * a mudança de nivel (evolução), daí */
public class Mochila {
	protected int level;
	protected int size;
  protected Item[] itens;

  public Mochila(int l){
  	this.level = l;
		this.size = 16;
		this.itens = new Item[this.size];
  }
}
