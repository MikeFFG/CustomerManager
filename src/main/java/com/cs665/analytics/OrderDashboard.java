package com.cs665.analytics;

import com.cs665.Framework.dashboards.Dashboard;
import com.cs665.Framework.order.Order;
import com.cs665.mockDB.Database;
import com.cs665.mockDB.OrderDB;

import java.time.LocalDateTime;

/**
 * Dashboards that can be created to show analytics in various time frames.
 * Created by mburke on 5/31/17.
 */
public class OrderDashboard extends Dashboard implements OrderObserver {
    private LocalDateTime startTime;
    private int totalOrdersInDuration;
    private int totalPriceInDuration;
    private OrderDB database;

    public OrderDashboard(LocalDateTime startTime) {
        this.startTime = startTime;
        this.database = OrderDB.getOrderDB();
        this.totalOrdersInDuration = calculateTotalOrdersInDuration();
        this.totalPriceInDuration = calculateTotalPriceInDuration();

        // Register new dashboard with the database (the observable object)
        if (!register(database)) {
            throw new IllegalStateException("Error connecting to database");
        }
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
        sb.append("My OrderDashboard\n")
                .append("Since:").append(startTime)
                .append("\nThere were ").append(totalOrdersInDuration)
                .append(" for a total of ").append(totalPriceInDuration);
        return sb.toString();
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

    /**
     * Register with the desired database
     * @param db
     * @return
     */
    @Override
    public boolean register(Database db) {
        return db.addObserver(this);
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
