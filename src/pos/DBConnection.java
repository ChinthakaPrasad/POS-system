/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

/**
 *
 * @author Chinthaka Prasad
 */
public class DBConnection {
    private static OrderList orderList;
    
    public static OrderList getOrderList(){
        if(orderList==null){
            orderList= new OrderList();
        }
        return orderList;
    }
    
}
