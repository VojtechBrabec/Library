/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashMap;

/**
 *
 * @author brabev04
 */
public class Client extends Person{
    protected HashMap<Long, Transaction> transactions = new HashMap<>();
    
    public Client(long ID, int birthYear, String name, String surname, Contact contact, Role role){
        super(ID, birthYear, name, surname, contact, role);
    }

    public long addTransaction(Transaction t){
        transactions.put(t.getID(), t);
        return t.getID();
    }
}
