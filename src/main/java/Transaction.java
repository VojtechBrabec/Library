import java.util.ArrayList;
import java.util.Date;
public abstract class Transaction {

    protected long clientID;
    protected Date createdOn;
    protected Date returnOn;
    protected ArrayList<Item> borrowedItems;
    protected TransactionType tType;


    public Transaction (long clientID, Date returnOn, ArrayList<Item> borrowedItems, TransactionType tType){
        this.clientID = clientID;
        createdOn = new Date();
        this.returnOn = returnOn;
        this.borrowedItems = borrowedItems;
        this.tType = tType;
    }

    public Transaction (long clientID, Date returnOn, Item borrowedItems, TransactionType tType){
        this.clientID = clientID;
        createdOn = new Date();
        this.returnOn = returnOn;
        this.borrowedItems = new ArrayList<>();
        this.borrowedItems.add(borrowedItems);
        this.tType = tType;
    }


    protected void setBorrowedItems(boolean borrowed){
        for(Item i:borrowedItems){
            setBorrowedItems(borrowed, i);
        }
    }

    protected void setBorrowedItems(boolean borrowed, Item item){
        item.setBorrowed(borrowed);
    }





}
