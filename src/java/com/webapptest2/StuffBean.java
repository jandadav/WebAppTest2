/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webapptest2;

import java.io.Serializable;
import java.util.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.UUID;

/**
 *
 * @author David
 */
//@ManagedBean(name = "stuffBean", eager = true)
//@SessionScoped
@Named//("stuffBean")
@SessionScoped
public class StuffBean implements Serializable{
    
    private static List<Stuff> avilableStuff = new ArrayList<>();  
    private Stuff selectedStuff;
    

    public StuffBean() {  
        
        
        
        this.populate();  
    }
    
    public void populate() {
        avilableStuff.clear();
        this.selectedStuff = null;
        
        Random rand = new Random();        
        for(int i = 0 ; i < 10 ; i++) { 
            avilableStuff.add(new Stuff(i, UUID.randomUUID().toString().substring(0, 8), rand.nextInt(49)+1, rand.nextInt(49)+1));  
        }
    } 
    public List<Stuff> getAvilableStuff() {
        return avilableStuff;
    }

    public Stuff getSelectedStuff() {
        return selectedStuff;
    }

    public void setSelectedStuff(Stuff selectedStuff) {
        this.selectedStuff = selectedStuff;
        System.out.println(selectedStuff.getId());
    }
    
    public boolean removeStuff(Stuff item){
        
        if(item.getQuantity()>0) {
            item.setQuantity(item.getQuantity()-1);
            return true;
        }else{
            return false;
            //avilableStuff.remove(item);
        }
    }
    public void addStuff(Stuff item){
        
        //see, if quantity of item > 1
        
        if(avilableStuff.contains(item)){
            Stuff cartItem = avilableStuff.get(avilableStuff.indexOf(item));
            cartItem.setQuantity(cartItem.getQuantity()+1);
        }else{
            avilableStuff.add(new Stuff(item.getId(), item.getItemName(), item.getPrice(), 1));
        }


    }
}
