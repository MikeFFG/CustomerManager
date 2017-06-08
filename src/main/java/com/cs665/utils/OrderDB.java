package com.cs665.utils;

import com.cs665.analytics.MyObserver;
import com.cs665.Framework.order.Order;
import com.cs665.order.OrderList;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock database to hold Orders
 * Created by mburke on 5/31/17.
 */
public class OrderDB {
    private List<Order> orderList = new ArrayList<>();
    private List<MyObserver> observers = new ArrayList<>();
    private static OrderDB orderDB = new OrderDB();

    // Singleton because we only want one DB per run
    private OrderDB() {}

    public static OrderDB getOrderDB() { return orderDB; }

    public void add(Order order) {
        orderList.add(order);
        myNotify();
    }

    // Part of the Observer pattern. Register an observer
    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    // Part of Observer pattern. Notify observers.
    private void myNotify() {
        for (MyObserver observer : observers) {
            observer.update();
        }
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

    // "Delete" DB. Mostly used for testing
    public void clear() {
        orderDB = new OrderDB();
    }

    public static String generateOrderID() {
        String serial;

        do {
            serial = RandomStringUtils.randomAlphanumeric(5);
        } while(getOrderDB().get(serial) != null);

        return serial;
    }

}
