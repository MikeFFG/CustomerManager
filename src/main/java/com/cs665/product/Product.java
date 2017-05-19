package com.cs665.product;

import com.cs665.utils.MockSerialDB;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public abstract class Product {
    protected String name;
    protected String serialNumber;
    protected int priceInCents;

    public Product(String name, int priceInCents) {
        this.name = name;
        this.priceInCents = priceInCents;
        serialNumber = MockSerialDB.generateNewProductSerial();
    }

    public Product() {};

    /*
     * Getters and Setters
     * Setter ONLY for priceInCents. Name, SerialNumber, ConnectionType
     * and Color are sent at manufacture time and can't be changed
     */
    public String getName() {
        return name;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }
}
