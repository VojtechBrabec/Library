import java.util.ArrayList;

public class Book extends Item{

    public Book(long ID, Author author, String title, String description, ArrayList<Genre> genres) {
        super(ID, author, title, description, genres);
    }

}
