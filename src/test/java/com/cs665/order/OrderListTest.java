package com.cs665.order;

import com.cs665.product.LargeSpeaker;
import com.cs665.product.SmallSpeaker;
import com.cs665.product.SurroundSpeaker;
import com.cs665.productProperties.ProductColor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by mburke on 5/28/17.
 */
public class OrderListTest {
    private OrderList newOrderList;
    private Order order1;
    private Order order2;
    private Order order3;
    private Order order4;

    @Before
    public void SetUp() {
        newOrderList = new OrderList();
        order1 = new StandardOrder();
        order1.addItem(new LargeSpeaker(ProductColor.BLACK));
        order1.addItem(new LargeSpeaker(ProductColor.BLACK));
        order1.addItem(new LargeSpeaker(ProductColor.BLACK));
        order1.setOrderTime( LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));
        newOrderList.add(order1);

        order2 = new StandardOrder();
        order2.addItem(new LargeSpeaker(ProductColor.OAK));
        order2.setOrderTime( LocalDateTime.of(1990, Month.APRIL, 15, 11, 30));
        newOrderList.add(order2);

        order3 = new StandardOrder();
        order3.addItem(new LargeSpeaker(ProductColor.WHITE));
        order3.addItem(new SurroundSpeaker(ProductColor.WHITE));
        order3.setOrderTime( LocalDateTime.of(2000, Month.APRIL, 15, 11, 30));
        newOrderList.add(order3);

        order4 = new StandardOrder();
        order4.addItem(new SmallSpeaker(ProductColor.BLACK));
        order4.setOrderTime( LocalDateTime.of(1989, Month.APRIL, 15, 11, 30));
        newOrderList.add(order4);
    }

    @Test
    public void test_positive_createIteratorByDate() {
        OrderListIterator iter = newOrderList.createIteratorByDate();
        Assert.assertEquals(order4.getOrderTime(), iter.getCurrentItem().getOrderTime());
        Assert.assertEquals(order2.getOrderTime(), iter.getCurrentItem().getOrderTime());
        Assert.assertEquals(order1.getOrderTime(), iter.getCurrentItem().getOrderTime());
        Assert.assertEquals(order3.getOrderTime(), iter.getCurrentItem().getOrderTime());
    }

    @Test
    public void test_positive_createIteratorByPrice() {
        OrderListIterator iter = newOrderList.createIteratorByPrice();
        Assert.assertEquals(order4.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
        Assert.assertEquals(order2.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
        Assert.assertEquals(order3.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
        Assert.assertEquals(order1.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
    }

    @Test
    public void test_positive_createIteratorDefault() {
        OrderListIterator iter = newOrderList.createIteratorDefault();
        Assert.assertEquals(order1.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
        Assert.assertEquals(order2.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
        Assert.assertEquals(order3.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
        Assert.assertEquals(order4.getTotalPriceInCents(), iter.getCurrentItem().getTotalPriceInCents());
    }
}
