/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author brabev04
 */
public class Main {
    public static void main(String[]args){
//        Library l = new Library();
//        l.addPerson(2000,"Jaroslav", "Basta", new Contact(10, 777777777, "email"), 'C');
//        try{
//            BinaryObjectStore.save("../saves/newfile", l);
//            System.out.println(BinaryObjectStore.load("../saves/newfile"));
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
        Library l = new Library();

        for(int i = 0; i<10; i++){
            Shelf s = l.newShelf("Shelf"+1);
            Person p = l.addPerson(1980+i, "Name"+i,"Surname"+i, null,'A');
            for(int j = 0; j<10; j++){
                l.newItem(s, p, "Title"+j, "Description"+j, l.newGenre("Fantasy", "Dungeons and Dragons"));
            }
        }

        System.out.println(l);

//        l.addPerson(2000,"Jaroslav", "Novak", null, 'C');
//        l.addPerson(1999, "Jan", "Autor", null, 'A');
//        Shelf s = l.newShelf("Shelf1");
//        System.out.println(l);
    }
}
