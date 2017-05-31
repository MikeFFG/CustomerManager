package com.cs665.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mburke on 5/16/17.
 */
public abstract class Order implements Cloneable {
    LocalDateTime orderTime;
    List<OrderComponent> items;
    int totalPriceInCents;

    public Order () {
        items = new ArrayList<>();
        orderTime = LocalDateTime.now();
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderComponent> getItems() {
        return items;
    }

    public void setItems(List<OrderComponent> items) {
        this.items = items;
        calculatePriceInCents();
    }

    public int getTotalPriceInCents() {
        return totalPriceInCents;
    }

    public void addItem(OrderComponent item) {
        items.add(item);
        calculatePriceInCents();
    }

    private void calculatePriceInCents() {
        int totalPriceInCents = 0;
        for (OrderComponent item : items) {
            totalPriceInCents += item.getPriceInCents();
        }
        this.totalPriceInCents = totalPriceInCents;
    }

    public void removeItem(OrderComponent component) {
        Iterator iter = items.listIterator();
        while(iter.hasNext()) {
            OrderComponent item = (OrderComponent) iter.next();
            if (item.getSerialNumber().equals(component.getSerialNumber())) {
                iter.remove();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (OrderComponent item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    public abstract Order clone();

}
