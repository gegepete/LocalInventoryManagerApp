import java.util.*;
import java.io.*;
public class Inventory implements Serializable {
    private static Inventory SINGLETON;
    public List<Item> items = new ArrayList<>();
    
    private Inventory(){
    }
    
    public static Inventory getInstance(){
        if (SINGLETON == null) {
            SINGLETON = new Inventory();
        }
        return SINGLETON;
    }
    
    public void addItem(Item i){
        items.add(i);
        System.out.println("Item " + i.name + " has been added to your inventory.");
    }
    
    public void updateItems(List<Item> items){
        this.items = items;
    }
    
    public void removeItem(int indexNr, int units) throws NoSuchItemException{
        Item i = items.get(indexNr);
        if (i.unitsNr == 0){
            items.remove(indexNr);
            throw new NoSuchItemException();
        }else{
            System.out.println(units + " units of item index " + indexNr + " have been removed from your inventory.");
            i.unitsNr -= units;
        }        
    }
    
    public void showItems(){
        for  (int i = 0; i < items.size(); i++) {
            System.out.println(i + " " + items.get(i));
        }
    }
    
    
}