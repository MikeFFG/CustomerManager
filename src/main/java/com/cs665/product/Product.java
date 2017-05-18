package com.cs665.product;

import com.cs665.utils.MockSerialDB;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public abstract class Product {
    protected String serialNumber;
    protected int priceInCents;

    public Product() {};

    public Product(int priceInCents) {
        serialNumber = MockSerialDB.generateNewProductSerial();
        this.priceInCents = priceInCents;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPrice(int priceInCents) {
        this.priceInCents = priceInCents;
    }
}
