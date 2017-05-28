package com.cs665.order;

import com.cs665.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/16/17.
 */
public abstract class Order {
    LocalDateTime orderTime;
    List<Product> items;
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

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
        calculatePriceInCents();
    }

    public void addItem(Product product) {
        items.add(product);
        calculatePriceInCents();
    }

    private void calculatePriceInCents() {
        int totalPriceInCents = 0;
        for (Product item : items) {
            totalPriceInCents += item.getPriceInCents();
        }
        this.totalPriceInCents = totalPriceInCents;
    }
}
