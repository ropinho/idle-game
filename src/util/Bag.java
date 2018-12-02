package util;

import java.util.ArrayList;
import item.Item;
import out.Console;

public abstract class Bag {
	
	private static int level = 1;
	private static int maxSize = 12;
	private static float slotCapacity = (float) 1.5; // capacidade de cada slot
	private static float maxWeight = maxSize * slotCapacity;
    private static ArrayList<Item> slot = new ArrayList<>();
    
    
    public static int getLevel() {
    	return level;
    }
    public static int getSize() {
    	return maxSize;
    }
    public static float getMaxWeight() {
    	return maxWeight;
    }
    
    public static float weight() {
    	float w = 0;
    	for (Item i : slot)
    		w += i.getWeight();
    	return w;
    }
    
    public static void upgradeCapacity() {
    	slotCapacity += 0.5;
    }
    
    public static void upgradeSize() {
    	maxSize += 2;
    }
    
    public static void levelUp() {
    	level++;
    	upgradeCapacity();
    	upgradeSize();
    }
    
    public static void add(Item item){
        if (slot.size() < maxSize) {
            // se o tamanho da lista for menor que o tamanho máximo suportado pela mochila
            if (weight() + item.getWeight() <= maxWeight){
                // se o acréscimo desse item não exceder o peso máximo
                slot.add(item);

            } else System.out.println("Impossível adicionar: Objeto muito pesado!");

        } else System.out.println("Impossível adicionar: Mochila cheia!");
    }
    
    public static void showInfo() {
        System.out.printf("--Mochila-[level %d]---------------\n", level);
        
        for (Item i : slot) {
            System.out.printf("%s\t%.2f kg\n", i.getName(), i.getWeight());
        }
        
        System.out.printf("\nNúmero de itens: %d (máx: %d)\n", slot.size(), maxSize);
        System.out.printf("Peso total: %.2fkg (máx: %.1fkg)\n", weight(), maxWeight);
        System.out.println("---------------------------------");
    }

}
