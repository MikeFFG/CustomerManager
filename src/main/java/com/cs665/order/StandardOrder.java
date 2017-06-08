package com.cs665.order;

import com.cs665.Framework.order.Order;
import com.cs665.Framework.order.OrderComponent;

import java.time.LocalDateTime;

/**
 * Created by mburke on 5/16/17.
 */
public class StandardOrder extends Order implements Cloneable {
    public StandardOrder() {
        super();
    }

    @Override
    public Order clone() {
        Order newOrder = new StandardOrder();
        newOrder.setOrderTime(LocalDateTime.of(this.getOrderTime().toLocalDate(), this.getOrderTime().toLocalTime()));
        for (OrderComponent item : items) {
            newOrder.addItem(item.clone());
        }
        return newOrder;
    }
}
