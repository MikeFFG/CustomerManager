package com.cs665.analytics;

import com.cs665.bundle.classes.TestProduct;
import com.cs665.order.Order;
import com.cs665.order.StandardOrder;
import com.cs665.productProperties.ProductColor;
import com.cs665.utils.OrderDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by mburke on 5/31/17.
 */
public class DashboardTest {
    @Before
    public void setUp() {
        // Create new orders in the month
        Order order1 = new StandardOrder();
        order1.setOrderTime(LocalDateTime.now().minusDays(1));
        order1.addItem(new TestProduct("Test", 10000, ProductColor.BLACK));

        Order order2 = new StandardOrder();
        order2.setOrderTime(LocalDateTime.now().minusDays(2));
        order2.addItem(new TestProduct("Test", 10000, ProductColor.BLACK));

        Order order3 = new StandardOrder();
        order3.setOrderTime(LocalDateTime.now().minusDays(3));
        order3.addItem(new TestProduct("Test", 10000, ProductColor.BLACK));

        // Create new orders older than a month
        Order order4 = new StandardOrder();
        order4.setOrderTime(LocalDateTime.now().minusDays(1).minusMonths(2));
        order4.addItem(new TestProduct("Test", 10000, ProductColor.BLACK));

        Order order5 = new StandardOrder();
        order5.setOrderTime(LocalDateTime.now().minusDays(2).minusMonths(3));
        order5.addItem(new TestProduct("Test", 10000, ProductColor.BLACK));

        Order order6 = new StandardOrder();
        order6.setOrderTime(LocalDateTime.now().minusDays(3).minusYears(1));
        order6.addItem(new TestProduct("Test", 10000, ProductColor.BLACK));
    }

    @After
    public void tearDown() {
        OrderDB.getOrderDB().clear();
    }

    @Test
    public void test_positive_dashboardAllTime() {
        // Create forever dashboard
        Dashboard dashboard = new Dashboard(LocalDateTime.now().minusYears(100));

        Assert.assertEquals(6, dashboard.getTotalOrdersInDuration());
        Assert.assertEquals(60000, dashboard.getTotalPriceInDuration());
    }

    @Test
    public void test_positive_dashboardMonth() {
        // Create last month dashboard
        Dashboard dashboard = new Dashboard(LocalDateTime.now().minusMonths(1));

        Assert.assertEquals(3, dashboard.getTotalOrdersInDuration());
        Assert.assertEquals(30000, dashboard.getTotalPriceInDuration());
    }
}
