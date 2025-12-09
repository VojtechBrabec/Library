/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.io.Serializable;



/**
 *
 * @author brabev04
 */
public class Library implements Serializable{
    private ArrayList<Transaction> transactions;
    private ArrayList<Person> people;
       
    public Library(){
        
    }
    
    public void addPerson(int ID, int birthYear, String name, String surname, Contact contact){
        people.add(new Person(ID, birthYear, name, surname, contact));
    }
    
}
