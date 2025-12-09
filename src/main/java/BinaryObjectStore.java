
import java.io.*;
public class BinaryObjectStore {
    public static void save(String path, Object o)throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(o);
        oos.close();
    }
    
    public static Object load(String path)throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Object o = ois.readObject();
        ois.close();
        return o;
    }
    
}
