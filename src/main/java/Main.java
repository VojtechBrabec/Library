/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;

/**
 *
 * @author brabev04
 */
public class Main {

    public static <T> void out(T o){
        System.out.println(o);
    }


    public static void main(String[]args){
        Library l = new Library();

        for(int i = 0; i<10; i++){
            long sID = l.newShelf("Shelf"+1);
            long pID = l.addPerson(1980+i, "Name"+i,"Surname"+i, null,Role.AUTHOR);
            l.addPerson(1990+i, "Name"+i*100,"Surname"+i*100, null,Role.CLIENT);
            Shelf s = l.getShelfByID(sID);
            Person p =  l.getPersonByID(pID);
            for(int j = 0; j<10; j++){
                l.newItem(s, p, "Title"+i+j, "Description"+i+j, l.newGenre("Fantasy", "Dungeons and Dragons"));
            }
        }

        String path = "src/saves/save.txt";


        Library loaded = null;

        try{
            BinaryObjectStore.save(path, l);
            loaded = (Library) BinaryObjectStore.load(path);

        }catch(Exception e){
            out(e);
        }

        l = loaded;
        out(l.getPersonByID(3));
        out(l.getItemByID(5));

        l.newBorrow(3L, 5L, null);

    }
}
