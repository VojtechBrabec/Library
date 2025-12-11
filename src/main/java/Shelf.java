import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Shelf implements Serializable{
    private long ID;
    private String name;
    private ArrayList<Item> items;
    private HashMap <Long, Item> itemsMap = new HashMap<>();
    private int capacity = 100;

//    public Shelf(long ID, String name, ArrayList<Item> items) {
//        this.ID = ID;
//        this.name = name;
//        this.items = items;
//    }

    public Shelf(long ID, String name){
        this.ID = ID;
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(Item i){
        items.add(i);
        itemsMap.put(i.getID(), i);
    }

    public Shelf(long ID, String name, int capacity){
        this.ID = ID;
        this.name = name;
        this.capacity=capacity;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public Item getItemByID(long ID){
//        for(Item i : items){
//            if(i.getID() == ID){
//                return i;
//            }
//        }
        return itemsMap.get(ID);
    }

    @Override
    public String toString(){
        String ret = "Name: " + name + "\nID: " + ID + "\n" + items.toString();
        return ret;
    }

}
