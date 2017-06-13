package com.cs665.mockDB;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static com.cs665.mockDB.MockIDGenerator.*;

/**
 * @author michael.burke
 * @since 5/18/17
 */
public class MockIDGeneratorTest {
    @Before
    public void setup() {
        customerIDs = new HashSet<String>();
        productSerials = new HashSet<String>();
    }

    @Test
    public void test_positive_generateNewProductSerial() {
        for (int i = 0; i < 1000; i++) {
            generateNewProductSerial();
        }
        Assert.assertEquals(1000, productSerials.size());
    }

    @Test
    public void test_positive_generateNewCustomerId() {
        for (int i = 0; i < 1000; i++) {
            generateNewCustomerID();
        }
        Assert.assertEquals(1000, customerIDs.size());
    }
}
