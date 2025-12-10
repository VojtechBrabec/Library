import java.io.Serializable;

public class IDManager implements Serializable {
    private long lastCreatedID = 0;

    public IDManager(){

    }

    public long createNewID(){
        return ++lastCreatedID;
    }

}
