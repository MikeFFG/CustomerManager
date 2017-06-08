package com.cs665.analytics;

import com.cs665.Framework.order.Order;
import com.cs665.utils.OrderDB;

import java.time.LocalDateTime;

/**
 * Dashboards that can be created to show analytics in various time frames.
 * Created by mburke on 5/31/17.
 */
public class Dashboard implements MyObserver{
    private LocalDateTime startTime;
    private int totalOrdersInDuration;
    private int totalPriceInDuration;
    private OrderDB database;

    public Dashboard(LocalDateTime startTime) {
        this.startTime = startTime;
        this.database = OrderDB.getOrderDB();
        this.totalOrdersInDuration = calculateTotalOrdersInDuration();
        this.totalPriceInDuration = calculateTotalPriceInDuration();

        // Register new dashboard with the database (the observable object)
        OrderDB.getOrderDB().addObserver(this);
    }

    /**
     * Update method that will get called by the observable object
     */
    @Override
    public void update() {
        this.database = OrderDB.getOrderDB();
        this.totalOrdersInDuration = calculateTotalOrdersInDuration();
        this.totalPriceInDuration = calculateTotalPriceInDuration();
    }

    public int getTotalOrdersInDuration() {
        update();
        return totalOrdersInDuration;
    }

    public int getTotalPriceInDuration() {
        update();
        return totalPriceInDuration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("My Dashboard\n")
                .append("Since:").append(startTime)
                .append("\nThere were ").append(totalOrdersInDuration)
                .append(" for a total of ").append(totalPriceInDuration);
        return sb.toString();
    }

    private int calculateTotalOrdersInDuration() {
        int total = 0;
        for (int i = 0; i < database.getAll().size(); i++) {
            Order currentOrder = database.getAll().get(i);
            if (currentOrder.getOrderTime().isAfter(startTime)) {
                total++;
            }
        }
        return total;
    }

    private int calculateTotalPriceInDuration() {
        int total = 0;
        for (int i = 0; i < database.getAll().size(); i++) {
            Order currentOrder = database.getAll().get(i);
            if (currentOrder.getOrderTime().isAfter(startTime)) {
                total += currentOrder.getTotalPriceInCents();
            }
        }
        return total;
    }
}
