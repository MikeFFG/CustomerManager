package com.cs665.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/27/17.
 */
public class OrderList {
    private List<Order> orderList;

    /* Constructors */

    public OrderList() {
        orderList = new ArrayList<>();
    }

    public OrderList(List<Order> orders) {
        orderList = new ArrayList<>(orders);
    }

    public OrderList(Order order) {
        orderList = new ArrayList<>();
        orderList.add(order);
    }

    public int size() {
        return orderList.size();
    }

    public Order get(int index) {
        return orderList.get(index);
    }

    public void add(Order order) {
        orderList.add(order);
    }

    public MyIterator<Order> createIterator() {
        return new OrderListIterator(this);
    }

    private class OrderListIterator  implements MyIterator<Order> {
        private OrderList orderList;
        private int index;

        public OrderListIterator(OrderList list) {
            orderList = list;
            index = 0;
        }

        public void setToFirst() {
            index = 0;
        }

        public void increment() {
            index++;
        }

        public boolean isDone() {
            return index >= orderList.size();
        }

        public Order getCurrentItem() {
            Order order = orderList.get(index);
            increment();
            return order;
        }
    }
}
