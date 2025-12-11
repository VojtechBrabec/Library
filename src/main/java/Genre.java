public class Genre {

    protected  long ID;
    protected String name;
    protected String description;

    public Genre(long ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[ ID:  " + ID + ", Name: " + name + ", Description: " + description + " ]";
    }
}
