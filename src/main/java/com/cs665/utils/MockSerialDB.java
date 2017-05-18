package com.cs665.utils;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author michael.burke
 * @since 5/18/17
 */
public class MockSerialDB {
    // package private
    static Set<String> productSerials = new HashSet<String>();
    static Set<String> customerIDs = new HashSet<String>();

    public static String generateNewProductSerial() {
        String serial;

        do {
            serial = RandomStringUtils.randomAlphanumeric(11);
        } while(!productSerials.add(serial));

        return serial;
    }

    public static String generateNewCustomerID() {
        String customerID;

        do {
            customerID = RandomStringUtils.randomNumeric(7);
        } while(!customerIDs.add(customerID));

        return customerID;
    }
}
