package com.cs665.utils;

import com.cs665.analytics.MyObserver;
import com.cs665.order.Order;
import com.cs665.order.OrderList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/31/17.
 */
public class OrderDB {
    private List<Order> orderList = new ArrayList<>();
    private List<MyObserver> observers = new ArrayList<>();
    private static OrderDB orderDB = new OrderDB();

    private OrderDB() {}

    public static OrderDB getOrderDB() { return orderDB; }

    public void add(Order order) {
        orderList.add(order);
        myNotify();
    }

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    public Order get(String orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getOrderID().equals(orderID)) {
                return orderList.get(i);
            }
        }
        return null;
    }

    public OrderList getAll() {
        return new OrderList(orderList);
    }

    public void clear() {
        orderDB = new OrderDB();
    }

    private void myNotify() {
        for (MyObserver observer : observers) {
            observer.update();
        }
    }
}
