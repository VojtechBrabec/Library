import java.util.ArrayList;
/**
 *
 * @author brabev04
 */
public class Item {
    protected long ID;

    protected boolean borrowed;
    protected ArrayList<Person> authors;
    protected String title;
    protected String description;
    protected ArrayList<Genre> genres;


    public Item(long ID, boolean borrowed, ArrayList<Person> authors, String title, String description, ArrayList<Genre>genres){
        this.ID = ID;
        this.borrowed = borrowed;
        this.authors = authors;
        this.title = title;
        this.description = description;
        this.genres = genres;
    }




    public long getID(){
        return ID;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public ArrayList<Person> getAuthors() {
        return authors;
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
}
