public class IDManager {

    private long newID = 0;

    public IDManager(){}

    public long createNewID(){
        return newID++;
    }

}
