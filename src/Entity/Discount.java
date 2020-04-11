/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ruhic
 */
public class Discount {
    
    private double price;
    private String type;
    
    public Discount(double price, String type){
        this.price = price;
        this.type = type;
    }
    
    public double fixed(double price){
        return 0;
    }
    
    public double flexible(double price){
        return 0;
    }
    
    public double variable(double price){
        return 0;
    }
    
    //if discount.type == flexible{
    //  if 0 <= getTotal from db <= 1000 {
    //    double price = amount/100;
    //  }
    //  if 1001 <= getTotal from db <= 5000{
    //      double price = (amount*2)/100
    //  }
    //  if 5001 <= getTotal from db < 10000{
    //      double price = (amount*3)/100
    //  }
    //}
    //

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}