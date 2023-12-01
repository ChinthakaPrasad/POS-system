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
public class Order {

    private String orderId;
    private String pNum;
    private String size;
    private int qty;
    private double amount;
    private String odStatus;
    public Order next;

    Order(String orderId, String pNum, String size, int qty, double amount, String odStatus) {
        this.orderId = orderId;
        this.pNum = pNum;
        this.size = size;
        this.qty = qty;
        this.amount = amount;
        this.odStatus = odStatus;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setPNum(String pNum) {
        this.pNum = pNum;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOdStatus(String odStatus) {
        this.odStatus = odStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPNum() {
        return pNum;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }

    public double getAmount() {
        return amount;
    }

    public String getOdStatus() {
        return odStatus;
    }

    public void printDetails() {
        System.out.println("\tOrder ID     : " + this.orderId);
        System.out.println("\tPhone Number : " + this.pNum);
        System.out.println("\tQTY          : " + this.qty);
        System.out.println("\tAmount       : " + this.amount);
        System.out.println("\tStatus       : " + this.odStatus);
    }

}
