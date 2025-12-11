import java.util.ArrayList;
/**
 *
 * @author brabev04
 */
public class Item {
    protected long ID;

    protected String title;
    protected String description;
    protected ArrayList<Genre> genres;
    protected Person author;
    protected boolean borrowed;
//    protected ArrayList<Person> authors;


    public Item(long ID, /*ArrayList<Person> authors,*/ Person author, String title, String description, ArrayList<Genre>genres){
        this.ID = ID;
        this.borrowed = false;
//        this.authors = authors;
        this.author = author;
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public Item(long ID, /*ArrayList<Person> authors,*/ Person author, String title, String description, Genre genre){
        this.ID = ID;
        this.borrowed = false;
//        this.authors = authors;
        this.author = author;
        this.title = title;
        this.description = description;
        this.genres = new  ArrayList<>();
        this.genres.add(genre);
    }




    public long getID(){
        return ID;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

//    public ArrayList<Person> getAuthors() {
//        return authors;
//    }
    public Person getAuthor(){
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + ID + "\n");
        sb.append("Title: " + title + "\n");
        sb.append("Description: " + description + "\n");
        sb.append("Aurthor: " + author+ "\n");
        sb.append("Genres: " + genres+ "\n");
        sb.append("Borrowed: " + borrowed + "\n");

        return sb.toString();
    }
}
