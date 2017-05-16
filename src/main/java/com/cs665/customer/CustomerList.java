package com.cs665.customer;

import java.util.List;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public class CustomerList {
    private List<Customer> customerList;

    public void addCustomer(Customer customer) {
        if (customerAlreadyExists(customer)) {
            throw new IllegalArgumentException("Customer already exists in our system.");
        } else {
            customerList.add(customer);
        }
    }

    private boolean customerAlreadyExists(Customer customer) {
        return customerList.contains(customer);
    }
}
