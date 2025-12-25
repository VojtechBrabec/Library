import java.util.HashMap;

public class Shelf {
    HashMap<Long, Item> items;

    public Shelf(){
        items = new HashMap<>();
    }
    public Shelf(HashMap<Long, Item> items){
        this.items = items;
    }




}
