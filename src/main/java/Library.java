import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Library implements Serializable {
    ArrayList<Shelf> shelves;
    HashMap<Long, Person> people;




    IDManager idm = new IDManager();



    private long newID(){
        return idm.createNewID();
    }




}
