import java.util.ArrayList;
import java.util.Date;

public class Borrow extends Transaction {

    protected Date borrowedOn;
    protected Date latestReturnOn;

    public Borrow(long ID, Client client, ArrayList<Item> items, Date borrowedOn, Date latestReturnOn) {
       super(ID, client, items, 'B');
       this.borrowedOn = borrowedOn;
       this.latestReturnOn = latestReturnOn;
    }

    private void setItemsBorrowed(){
        for(Item i :items){
            i.borrowed = true;
        }
    }
    
    
}
