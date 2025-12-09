import java.io.Serializable;
import java.util.ArrayList;

public class Shelf implements Serializable{
    private int ID;
    private String name;
    private ArrayList<Item> items;

    public Shelf(int ID, String name, ArrayList<Item> items) {
        this.ID = ID;
        this.name = name;
        this.items = items;
    }

    public Shelf(int ID, String name){
        this.ID = ID;
        this.name = name;
        this.items = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public Item getItemByID(int ID){
        for(Item i : items){
            if(i.getID() == ID){
                return i;
            }
        }
        return null;
    }


}
