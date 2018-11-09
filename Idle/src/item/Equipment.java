package item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import item.*;

public class Equipment{
	
    
	public static Item generateEquipment() throws IOException{
        
        BufferedReader buff;

        List<String[]> listEnemy = new ArrayList<String[]>();
        String line;
        String[] data = new String[2];

        try{
            // Open archive
            buff = new BufferedReader(new FileReader("data/equipments.csv"));
            // 
            line = buff.readLine();

            while(line != null){
                line = buff.readLine();

                if(line == null) break;
                
                data = line.split(",");
                listEnemy.add(data);
            }

            buff.close();
        } catch (FileNotFoundException e){
            System.out.println("Erro: " + e.toString());
        }

        int index = (int) (Math.random() * (listEnemy.size()-1));

        return new Item(listEnemy.get(index)[0], Integer.parseInt(listEnemy.get(index)[1]), listEnemy.get(index)[2]);
    }
}