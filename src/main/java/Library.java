/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

public class Library implements Serializable{
    private HashMap<Long, Transaction> transactions;
    private HashMap<Long, Person> people;
    private ArrayList<Shelf> shelves;
    private IDManager idManager;

//    private final long defaultReturnBy = System.currentTimeMillis() + 14*24*60*60*1000;
    private final Date defaultReturnBy = new Date(System.currentTimeMillis() + 14*24*60*60*1000);


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
     * @param role - CLIENT - Client
     *             - EMPLYEE - Employee
     *             - AUTHOR - Author
     *             - DEFAULT - default case, will be created as a Person;
     * */
    public long addPerson(int birthYear, String name, String surname, Contact contact, Role role){
        long ID = newID();
        Person p;
        switch (role){
            case EMPLOYEE:
                p = new Employee(ID, birthYear, name, surname, contact, Role.EMPLOYEE);
                people.put(ID, p);
                break;
            case CLIENT:
                p = new Client(ID, birthYear, name, surname, contact, Role.CLIENT);
                people.put(ID, p);
                break;
            case AUTHOR:
                p = new Author(ID, birthYear, name, surname, Role.AUTHOR);
                people.put(ID, p);
                break;
            default:
                p = new Person(ID, birthYear, name, surname, contact, Role.DEFAULT);
                people.put(ID, p);
        }
        return ID;
    }

    public long newShelf(String name, int capacity){
        long ID = newID();
        Shelf s = new Shelf(ID, name, capacity);
        shelves.add(s);
        return ID;
    }

    public long newShelf(String name){
        long ID = newID();
        Shelf s = new Shelf(ID, name);
        shelves.add(s);
        return ID;
    }

    public long newItem(Shelf shelf, /*ArrayList<Person> authors,*/Person author, String title, String description, ArrayList<Genre>genres) throws IllegalArgumentException{
        if(shelf ==null || author == null ||title ==null||description ==null|| genres == null){
            throw new IllegalArgumentException("Arguments can't be null");
        }
        long ID = newID();
        Item i = new Item(ID,author, title, description, genres);
        shelf.addItem(i);
        return ID;
    }
    public long newItem(Shelf shelf, /*ArrayList<Person> authors,*/Person author, String title, String description, Genre genre) throws IllegalArgumentException{
        if(shelf ==null || author == null ||title ==null||description ==null|| genre == null){
            throw new IllegalArgumentException("Arguments can't be null");
        }
        long ID = newID();
        Item i = new Item(ID,author, title, description, genre);
        shelf.addItem(i);
        return ID;
    }

    public long newItem(long shelfID, /*ArrayList<Person> authors,*/ Person author, String title, String description, ArrayList<Genre>genres) throws IllegalArgumentException, NullPointerException{
        if(author == null ||title ==null||description ==null|| genres == null){
            throw new IllegalArgumentException("Arguments can't be null");
        }
        if(shelves==null){
            throw new NullPointerException("There are no shelves initialized in the library");
        }
        long ID;
        for(Shelf shelf : shelves){
            if(shelf.getID() == shelfID){
                ID = newID();
                Item i = new Item(ID,author, title, description, genres);
                shelf.addItem(i);
                return ID;
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

    public Long newBorrow(long clientID, ArrayList<Long> itemsToBorrowID, Date returnBy){
        Client c = (Client) this.getPersonByID(clientID);
        if(returnBy == null){
            returnBy = defaultReturnBy;
        }

        ArrayList<Item> itemsToBorrow = new ArrayList<>();
        for(Long l : itemsToBorrowID){
            itemsToBorrow.add(this.getItemByID(l));
        }

        return this.newBorrow(c, itemsToBorrow,returnBy);


    }

    public Long newBorrow(Long clientID,Long itemToBorrow, Date returBy){
        Client c =  (Client) this.getPersonByID(clientID);
        if(returBy == null){
            returBy = defaultReturnBy;
        }
        ArrayList<Item> itemsToBorrow = new ArrayList<>();
        itemsToBorrow.add(this.getItemByID(itemToBorrow));

        long newBorrowID;
        try{
            newBorrowID = this.newBorrow(c, itemsToBorrow,returBy);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }

        return newBorrowID = 0-1;
    }

    private long newBorrow(Client client, ArrayList<Item> itemsToBorrow, Date returnBy) throws IllegalArgumentException{
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
                Transaction borrow = this.getTransactionByID(i.getInTransactionID());
                throw new IllegalArgumentException("Item " + i + " was already borrowed in transaction \n" + borrow);
            }
        }


        long borrowID = newID();
        long returnID = newID();
        Borrow b = new Borrow(borrowID, returnID, client, itemsToBorrow, new Date(), returnBy);
        Return r = new Return(returnID, borrowID, client, itemsToBorrow);
//        if(returnBy != null){
//            b = new Borrow(borrowID, returnID, client, itemsToBorrow, new Date(), returnBy);
//            r = new Return(returnID, borrowID, client, itemsToBorrow);
//        }else{
//            b = new Borrow(borrowID, returnID, client, itemsToBorrow, new Date(), defaultReturnBy);
//            r = new Return(returnID, borrowID, client, itemsToBorrow);
//        }
        transactions.put(borrowID, b);
        transactions.put(returnID, r);
        client.addTransaction(b);
        client.addTransaction(r);
        return b.getID();
    }



        public Return newReturn(long borrowID){
        Borrow borrow = (Borrow) getTransactionByID(borrowID);
        if(borrow == null){
            throw new IllegalArgumentException("The borrow with ID " + borrowID + " does not exist");
        }

        Date shouldReturnOn = borrow.latestReturnOn;

        Return r = (Return) transactions.get(borrow.getReturnID());
        r.setItemsBorrowed(false);

        Date returnDate = new Date();
        r.setReturnedOnDate(returnDate);

        if(!shouldReturnOn.after(returnDate)){
            System.out.println("The return of the following items is late items:\n" + r.getItems().toString());
        }
        borrow.setIsActive(false);
        return r;
//        Client client = borrow.getClient();


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

    public ArrayList<Shelf> getShelves(){
        return shelves;
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

    public Collection<Person> getPeople(){
        return people.values();
    }

    public Collection<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        for(Shelf s : shelves){
            items.addAll(s.getItems());
        }
        return items;
    }

    public Shelf getShelfByID(long ID){
        for(Shelf s : shelves){
            if(s.getID() == ID){
                return s;
            }
        }
        throw new IllegalArgumentException("Shelf with ID " + ID + " does not exist.");
    }

    public Collection<Transaction> getTransactions(){
        return transactions.values();
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
