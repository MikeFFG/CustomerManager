package com.cs665.order;

import com.cs665.Framework.order.Order;

/**
 * Created by mburke on 5/27/17.
 */
public abstract class OrderListIterator {
    protected OrderList orderList;
    protected int index;

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
