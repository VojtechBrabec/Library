/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author brabev04
 */
public class Person implements Serializable {
    
    protected long ID;
	protected int birthYear;
	protected String name;
	protected String surname;
	protected Contact contact;
    protected Role role;
    protected HashMap<Long, Transaction> transactions = new HashMap<>();

	public Person(long ID, int birthYear, String name, String surname, Contact contact, Role role) {
		this.ID = ID;
		this.birthYear = birthYear;
		this.name = name;
		this.surname = surname;
		this.contact = contact;
        this.role = role;
	}

	public Person(long ID, int birthYear, String name, String surname, Role role) {
		this.ID = ID;
		this.birthYear = birthYear;
		this.name = name;
		this.surname = surname;
        this.role = role;
	}

    public long addTransaction(Transaction t){
        transactions.put(t.getID(), t);
        return t.getID();
    }

    public long getID(){
        return this.ID;
    }
        
        
        @Override
        public String toString(){
            String a = "[ ID "+ID+" " + name +" " + surname + " "+ birthYear + " " + role;
            if(contact != null){
                a += "\nContact: " + contact.toString();
            }
            a+=" ]";
            return a;
        }
    
}
