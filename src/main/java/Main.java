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
        Library l = new Library();
        l.addPerson(2000,"Jaroslav", "Basta", new Contact(10, 777777777, "email"), 'C');
        try{
            BinaryObjectStore.save("../saves/newfile", l);
            System.out.println(BinaryObjectStore.load("../saves/newfile"));
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
