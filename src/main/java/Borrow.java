/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author brabev04
 */
public class Borrow extends Transaction {
    
   public Borrow(int ID, Client client, Item item){
       super(ID, client, item, 'b');
   } 
    
    
}
