package com.cs665.mockDB;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Takes the place of a DB in this application. Ensures all
 * products have unique serial numbers and all customers have unique IDs by using
 * a Set for each. Won't persist between runs of the program. Will become important
 * when Customer search and Product search are implemented.
 * @author michael.burke
 * @since 5/18/17
 */
public class MockIDGenerator {
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
