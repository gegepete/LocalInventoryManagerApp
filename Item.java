import java.io.*;
public class Item implements Serializable {
    String name;
    String entryDoc; // used as FF0000001/30.12.2015
    int unitsNr;
    
    public Item(String name, String entryDoc, int unitsNr){
        this.name = name;
        this.entryDoc = entryDoc;
        this.unitsNr = unitsNr;
    }
        
    @Override
    public String toString(){
        return "Item " + this.name + " - Document number " + this.entryDoc + " - Units " + this.unitsNr;
    }
}