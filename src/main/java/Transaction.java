/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
/**
 *
 * @author brabev04
 */
public class Transaction implements Serializable {
    
    protected Client client;
    protected Item item;
    protected char transactionType;
    protected int ID;
    
    public Transaction(int ID, Client client, Item item, char transactionType){
        this.client = client;
        this.item = item;
        this.transactionType = transactionType;
        this.ID = ID;
    }

}
