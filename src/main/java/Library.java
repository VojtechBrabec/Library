/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

public class Library implements Serializable{
    private HashMap<Long, Transaction> transactions;
    private HashMap<Long, Person> people;
    private ArrayList<Shelf> shelves;
    private IDManager idManager;

    private final long defaultReturnBy = System.currentTimeMillis() + 14*24*60*60*1000;


    public Library(){
        transactions = new HashMap<>();
        people = new HashMap<>();
        shelves = new ArrayList<>();
        this.idManager = new IDManager();
    }
    public Library(HashMap<Long, Transaction> transactions, HashMap<Long, Person> people){
        this.people = people;
        this.transactions = transactions;
        this.idManager = new IDManager();
    }


    /**
     * @param birthYear - birthyear;
     * @param name - name;
     * @param surname - surname;
     * @param contact - contact;
     * @param typeOfPerson - 'C' - Client
     *                     - 'E' - Employee
     *                     - '' - default case, will be created as a Person;
     * */
    public void addPerson(int birthYear, String name, String surname, Contact contact, char typeOfPerson){
        long ID = newID();
        switch (typeOfPerson){
            case 'E':
                people.put(ID, new Employee(ID, birthYear, name, surname, contact));
                break;
            case 'C':
                people.put(ID, new Client(ID, birthYear, name, surname, contact));
                break;
            default: people.put(ID, new Person(ID, birthYear, name, surname, contact));
        }

    }


    public void newBorrow(Client client, ArrayList<Item> itemsToBorrow, Date returnBy) throws IllegalArgumentException{
        if(client == null){
            throw new IllegalArgumentException("No client was selected");
        }
        if(itemsToBorrow == null){
            throw new IllegalArgumentException("No items were selected");
        }
        if(itemsToBorrow.isEmpty()){
            throw new IllegalArgumentException("No items were selected");
        }

        for (Item i:itemsToBorrow){
            if(i.borrowed){
                throw new IllegalArgumentException("Item " + i + " was already borrowed");
            }
        }

        if(returnBy != null){
            Borrow b = new Borrow(newID(), client, itemsToBorrow, new Date(), returnBy);
        }else{
            Borrow b = new Borrow(newID(), client, itemsToBorrow, new Date(), new Date(defaultReturnBy));
        }
    }

    public Object[] getItemInShelfByID(long itemID){
        for(Shelf s:shelves){
            Item i = s.getItemByID(itemID);
            if(i!= null){
                return new Object[]{i, s};
            }
        }

        return new Object[]{null, null};
    }

    public Item getItemByID(long ID){
        for (Shelf s : shelves){
            Item i = s.getItemByID(ID);
            if(i != null){
                return i;
            }
        }
        return null;
    }

    public Transaction getTransactionByID(long ID){
//        for(Transaction t : transactions){
//            if(t.getID() == ID){
//                return t;
//            }
//        }

        return transactions.get(ID);
    }

    public Person getPersonByID(long ID){
//        for(Person p : people){
//            if(p.getID() == ID){
//                return p;
//            }
//        }
        return people.get(ID);
    }

    private long newID(){
        return idManager.createNewID();
    }
}
