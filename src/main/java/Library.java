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


    public Library(HashMap<Long, Transaction> transactions, HashMap<Long, Person> people, ArrayList<Shelf>shelves){
        this.people = people;
        this.transactions = transactions;
        this.shelves = shelves;
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
    public Person addPerson(int birthYear, String name, String surname, Contact contact, char typeOfPerson){
        long ID = newID();
        Person p;
        switch (typeOfPerson){
            case 'E':
                p = new Employee(ID, birthYear, name, surname, contact);
                people.put(ID, p);
                break;
            case 'C':
                p = new Client(ID, birthYear, name, surname, contact);
                people.put(ID, p);
                break;
            case 'A':
                p = new Author(ID, birthYear, name, surname);
                people.put(ID, p);
                break;
            default:
                p = new Person(ID, birthYear, name, surname, contact);
                people.put(ID, p);
        }
        return p;
    }

    public Shelf newShelf(String name, int capacity){
        Shelf s = new Shelf(newID(), name, capacity);
        shelves.add(s);
        return s;
    }

    public Shelf newShelf(String name){
        Shelf s = new Shelf(newID(), name);
        shelves.add(s);
        return s;
    }

    public Item newItem(Shelf shelf, /*ArrayList<Person> authors,*/Person author, String title, String description, ArrayList<Genre>genres) throws IllegalArgumentException{
        if(shelf ==null || author == null ||title ==null||description ==null|| genres == null){
            throw new IllegalArgumentException("Arguments can't be null");
        }
        Item i = new Item(newID(),author, title, description, genres);
        shelf.addItem(i);
        return i;
    }
    public Item newItem(Shelf shelf, /*ArrayList<Person> authors,*/Person author, String title, String description, Genre genre) throws IllegalArgumentException{
        if(shelf ==null || author == null ||title ==null||description ==null|| genre == null){
            throw new IllegalArgumentException("Arguments can't be null");
        }
        Item i = new Item(newID(),author, title, description, genre);
        shelf.addItem(i);
        return i;
    }

    public Item newItem(long shelfID, /*ArrayList<Person> authors,*/ Person author, String title, String description, ArrayList<Genre>genres) throws IllegalArgumentException, NullPointerException{
        if(author == null ||title ==null||description ==null|| genres == null){
            throw new IllegalArgumentException("Arguments can't be null");
        }
        if(shelves==null){
            throw new NullPointerException("There are no shelves initialized in the library");
        }
        for(Shelf shelf : shelves){
            if(shelf.getID() == shelfID){
                Item i = new Item(newID(),author, title, description, genres);
                shelf.addItem(i);
                return i;
            }
        }
        throw new IllegalArgumentException("No such shelf exists");
    }

    public Genre newGenre(String name, String description) throws IllegalArgumentException{
        if(name == null || description ==null){
            throw new IllegalArgumentException("Arguments can't be null");
        }
        Genre g = new Genre(newID(), name, description);
        return g;
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


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Transactions:\n" + transactions.toString());
        sb.append("\nPeople:\n" + people.toString());
        sb.append("\nShelves:\n" + shelves.toString());

        return sb.toString();
    }
}
