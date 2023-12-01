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
public class OrderController {

    public static final String orderStatus[] = {"Processing", "Delivering", "Delivered"};
    public static final String tShirtSizes[] = {"XS", "S", "M", "L", "XL", "XXL"};
    public static final double tShirtCost[] = {600, 800, 900, 1000, 1100, 1200};

    public static String genarateOrderId() {

        Order[] tempArray = DBConnection.getOrderList().toArray();
        if (tempArray.length != 0) {
            String id = (tempArray[tempArray.length - 1]).getOrderId();
            int num = Integer.parseInt(id.split("[#]")[1]);
            num++;
            return String.format("ODR#%05d", num);
        }
        return "ODR#00001";
    }

    public static boolean checkNum(String num) {
        if (num.length() == 10 && num.charAt(0) == '0') {
            return true;
        }
        return false;
    }

    public static boolean checkSize(String size) {
        boolean isValidSize = false;

        for (int i = 0; i < tShirtSizes.length; ++i) {
            if (size.toUpperCase().equals(tShirtSizes[i])) {
                isValidSize = true;
            }
        }
        return isValidSize;
    }

    public static double calculateAmount(String size, int qty) {

        int index = 0;
        for (int i = 0; i < tShirtSizes.length; ++i) {
            if (size.equals(tShirtSizes[i])) {
                index = i;
            }

        }

        return tShirtCost[index] * qty;
    }

    public static boolean addOrder(Order order) {
        OrderList orderList = DBConnection.getOrderList();
        return orderList.add(order);
    }

    public static Order searchOrder(String id) {
        OrderList orderList = DBConnection.getOrderList();
        return orderList.getOrderFromOrderId(id);
    }

    public static boolean checkValidNum(String id) {
        OrderList orderList = DBConnection.getOrderList();
        return orderList.isValidId(id);
    }

    public static boolean deleteOrder(String id) {
        OrderList orderList = DBConnection.getOrderList();
        Order[] array = orderList.toArray();
        Order temp = null;

        for (int i = 0; i < array.length; ++i) {
            if (array[i].getOrderId().equals(id)) {
                temp = array[i];
                break;
            }
        }
        if (temp != null) {
            boolean isDelete = orderList.remove(id);
            return isDelete;
        } else {
            return false;
        }
    }

    public static String[] extendStringArray(String arr[]) {
        String tempArr[] = new String[arr.length + 1];
        int i = 0;
        for (String a : arr) {
            tempArr[i] = a;
            ++i;
        }
        return tempArr;
    }

}
