/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Date;

public class Return extends Transaction{

    protected Date returnedOn;
    long borrowID;

//    public Return(long ID,long borrowID, Client client, ArrayList<Item> items, Date returnedOn){
//        super(ID, client, items, 'R');
//        this.returnedOn = returnedOn;
//    }

    public Return(long ID, long borrowID, Client client, ArrayList<Item>items){
        super(ID, client, items, 'R');
        this.borrowID = borrowID;
    }



    protected void setItemsBorrowed(boolean borrowed){
        for(Item i:items){
            i.setBorrowed(borrowed);
            i.setInTransactionID(-1);
        }
    }

    public long getBorrowID(){
        return borrowID;
    }

    public void setReturnedOnDate(Date returnedOn){
        this.returnedOn = returnedOn;
    }

}
