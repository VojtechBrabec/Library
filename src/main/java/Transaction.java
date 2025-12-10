import java.io.Serializable;
import java.util.ArrayList;

public class Transaction implements Serializable {
    
    protected Client client;
    protected ArrayList<Item> items;
    protected char transactionType;
    protected long ID;



    /**
     * @param transactionType : 'R' = return
     *                        : 'B' = borrow
     * */
    public Transaction(long ID, Client client, ArrayList<Item> items, char transactionType){
        this.client = client;
        this.items = items;
        this.transactionType = transactionType;
        this.ID = ID;
    }

    public long getID(){
        return this.ID;
    }

    public Client getClient(){
        return client;
    }
    public ArrayList<Item> getItems(){
        return items;
    }

}
