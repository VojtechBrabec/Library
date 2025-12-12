import java.io.Serializable;
import java.util.ArrayList;

public abstract class Transaction implements Serializable {
    
    protected Client client;
    protected ArrayList<Item> items;
    protected char transactionType;
    protected long ID;
    protected boolean isActive = false;
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

    protected abstract void setItemsBorrowed(boolean borrowed);


    public long getID(){
        return this.ID;
    }

    public Client getClient(){
        return client;
    }
    public ArrayList<Item> getItems(){
        return items;
    }

    public void setIsActive(boolean active){
        isActive = active;
    }

    @Override
    public String toString(){
        return "[ ID: " + ID + " Client " + client + " Items: " + items.toString();
    }

}
