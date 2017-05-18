package com.cs665.product;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public abstract class Product {
    private int serialNumber;
    private double price;

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
