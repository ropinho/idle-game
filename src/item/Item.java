package item;

public class Item {
	
    protected String name;
    protected float weight;
    protected float price;
    
    public Item(String name, float w, float pr) {
    	this.name = name;
    	this.weight = w;
    	this.price = pr;
    }
    
    public String getName() {
    	return name;
    }
    public float getWeight() {
    	return weight;
    }
    public float getPrice() {
    	return price;
    }
    
    
}
