package com.cs665.utils;

import org.junit.Test;
import org.junit.Assert;

import static com.cs665.utils.MockSerialDB.*;

/**
 * @author michael.burke
 * @since 5/18/17
 */
public class MockSerialDBTest {
    @Test
    public void test_generateNewProductSerial() {
        for (int i = 0; i < 1000; i++) {
            generateNewProductSerial();
        }
        Assert.assertEquals(1000, productSerials.size());
    }

    @Test
    public void test_generateNewCustomerId() {
        for (int i = 0; i < 1000; i++) {
            generateNewCustomerID();
        }
        Assert.assertEquals(1000, customerIDs.size());
    }
}
