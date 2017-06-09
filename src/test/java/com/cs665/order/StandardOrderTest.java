package com.cs665.order;

import com.cs665.Framework.order.Order;
import com.cs665.product.LargeSpeaker;
import com.cs665.product.SmallSpeaker;
import com.cs665.productProperties.ProductColor;
import com.cs665.mockDB.MockIDGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by mburke on 5/31/17.
 */
public class StandardOrderTest {
    private LocalDateTime dateTime = LocalDateTime.of(2016, 10, 14, 2, 30);
    private String smallSpeakerSerial = MockIDGenerator.generateNewProductSerial();
    private String largeSpeakerSerial = MockIDGenerator.generateNewProductSerial();

    @Test
    public void test_positive_clone() {
        // Create original object
        Order order = new StandardOrder();
        order.setOrderTime(dateTime);

        SmallSpeaker smallSpeaker = new SmallSpeaker(ProductColor.BLACK);
        smallSpeaker.setSerialNumber(smallSpeakerSerial);
        order.addItem(smallSpeaker);

        LargeSpeaker largeSpeaker = new LargeSpeaker(ProductColor.OAK);
        largeSpeaker.setSerialNumber(largeSpeakerSerial);
        order.addItem(largeSpeaker);

        // Clone
        Order newOrder = order.clone();

        // Assert they are the same
        Assert.assertEquals(order.getOrderTime(), newOrder.getOrderTime());
        Assert.assertEquals(order.getTotalPriceInCents(), newOrder.getTotalPriceInCents());
        for (int i = 0; i < order.getItems().size(); i++) {
            Assert.assertTrue(order.getItems().get(i).getName().equals(newOrder.getItems().get(i).getName()));
            Assert.assertEquals(order.getItems().get(i).getPriceInCents(), newOrder.getItems().get(i).getPriceInCents());
            Assert.assertTrue(order.getItems().get(i).getSerialNumber().equals(newOrder.getItems().get(i).getSerialNumber()));
        }

        // Change original
        order.setOrderTime(LocalDateTime.now());
        order.getItems().get(0).setSerialNumber("fake");

        // Assert newOrder hasn't changed
        Assert.assertEquals(dateTime, newOrder.getOrderTime());
        Assert.assertEquals(smallSpeakerSerial, newOrder.getItems().get(0).getSerialNumber());
    }
}
