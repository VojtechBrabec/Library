/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Date;

public class Return extends Transaction{
    
    public Return(long ID, Client client, ArrayList<Item> items, Date borrowedOn, Date latestReturnOn){
        super(ID, client, items, 'R');

    }


}
