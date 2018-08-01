import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {                            
        try(
            InputStreamReader inCons = new InputStreamReader(System.in);
            BufferedReader cons = new BufferedReader(inCons);        
        ){
            String cmd;            
            while (true) {                
                System.out.println("Please enter your command: ");
                cmd = cons.readLine();
                String[] input = cmd.split("\\s+");
                
                try {
                    switch(input[0]){
                        case "exit":
                            try (
                                FileOutputStream fos = new FileOutputStream("E:/items");
                                ObjectOutputStream out = new ObjectOutputStream(fos);
                            ){
                                out.writeObject(Inventory.getInstance().items);                                    
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            System.out.println("The program has been closed. See you next time!");
                            return;
                        case "add":
                            Item i = new Item(input[1], input[2], Integer.parseInt(input[3]));
                            Inventory.getInstance().addItem(i);                            
                            break;
                        case "remove":
                            Inventory.getInstance().removeItem(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                            break;
                        case "update":
                            try(
                                FileInputStream fis = new FileInputStream("E:/items");
                                ObjectInputStream in = new ObjectInputStream(fis);
                            ){
                                List<Item> items = (List<Item>) in.readObject();
                                Inventory.getInstance().updateItems(items);
                                System.out.println("List has been loaded from disk.");
                                Inventory.getInstance().items.forEach(System.out::println);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            break;
                        case "list":
                            Inventory.getInstance().showItems();                            
                            break;
                        default :
                        System.err.println("Command not available, please retry.");                
                    }
                }catch(NoSuchItemException e){
                    System.out.println("This item does not exist (anymore)!");
                }
            }
            
            
        }catch(Exception e){
            e.printStackTrace();        
        }
    }
}