/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
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

	public Person(long ID, int birthYear, String name, String surname, Contact contact) {
		this.ID = ID;
		this.birthYear = birthYear;
		this.name = name;
		this.surname = surname;
		this.contact = contact;
	}

	public Person(long ID, int birthYear, String name, String surname) {
		this.ID = ID;
		this.birthYear = birthYear;
		this.name = name;
		this.surname = surname;
	}

    public long getID(){
        return this.ID;
    }
        
        
        @Override
        public String toString(){
            String a = "[  " + name +" " + surname + " "+ birthYear + "\n"+contact.toString();
            return a;
        }
    
}
