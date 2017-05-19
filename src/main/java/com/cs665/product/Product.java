package com.cs665.product;

import com.cs665.productProperties.ProductColor;
import com.cs665.productProperties.ProductConnectionType;
import com.cs665.utils.MockSerialDB;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public abstract class Product {
    protected String name;
    protected String serialNumber;
    protected int priceInCents;
    protected ProductColor color;
    protected ProductConnectionType connectionType;

    public Product(String name, int priceInCents, ProductColor color, ProductConnectionType connectionType) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.color = color;
        this.connectionType = connectionType;
        serialNumber = MockSerialDB.generateNewProductSerial();
    }

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

    public ProductColor getColor() {
        return color;
    }

    public ProductConnectionType getConnectionType() {
        return connectionType;
    }
}
