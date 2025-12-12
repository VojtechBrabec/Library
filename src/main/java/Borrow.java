import java.util.ArrayList;
import java.util.Date;

public class Borrow extends Transaction {

    protected Date borrowedOn;
    protected Date latestReturnOn;
    protected long returnID;

    public Borrow(long ID, long returnID, Client client, ArrayList<Item> items, Date borrowedOn, Date latestReturnOn) {
       super(ID, client, items, 'B');
       this.borrowedOn = borrowedOn;
       this.latestReturnOn = latestReturnOn;
       this.returnID = returnID;
       setItemsBorrowed(true);
       isActive = true;
    }

    protected void setItemsBorrowed(boolean borrowed) {
        for(Item i : items){
            i.setBorrowed(borrowed);
            i.setInTransactionID(this.ID);
        }
    }


    public long getReturnID() {
        return returnID;
    }
    
    
}
