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
public class OrderList {

    private Order first;

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int count = 0;
        if (!isEmpty()) {
            Order temp = first;
            while (temp != null) {
                temp = temp.next;
                count++;
            }
            return count;
        }
        return count;
    }

    public boolean add(Order order) {
        if (isEmpty()) {
            first = order;
        } else {
            Order temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = order;
        }
        return true;
    }

    public Order[] toArray() {
        Order tempArray[] = new Order[size()];
        if (!isEmpty()) {
            Order temp = first;
            int i = 0;
            while (temp != null) {
                tempArray[i] = temp;
                temp = temp.next;
                ++i;
            }
            return tempArray;
        }
        return new Order[0];
    }

    public boolean remove(String orderId) {
        boolean isExist = false;
        Order temp = first;
        int count = 1;

        while (temp != null) {
            if (temp.getOrderId().equals(orderId)) {
                isExist = true;
                break;
            }
            temp = temp.next;
            count++;
        }

        if (isExist) {
            if (size() > 1 && size() < count) {
                temp = temp.next.next;
                return isExist;
            } else if (size() == 1) {
                this.first = null;
                return isExist;
            } else if (size() == count) {
                temp = null;
                return isExist;
            }

        }
        return isExist;
    }

    public void remove(int index) {
        if (index > 0 && index < size() - 1) {

            int count = 0;
            Order temp = first;
            while (count++ < index - 1) {
                temp = temp.next;
            }
            //Order temp1=temp;
            temp.next = temp.next.next;
        } else if (index == 0) {
            first = first.next;
        } else if (index == size()) {
            Order temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp = null;
        } else {
            System.out.println("\n\t\t\tInvalid ID..!");
        }
    }

    public Order getOrderFromOrderId(String id) {
        Order temp = first;
        while (temp != null) {
            if (id.equals(temp.getOrderId())) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean isValidId(String id) {
        Order temp = first;
        while (temp != null) {
            if (id.equals(temp.getPNum())) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
