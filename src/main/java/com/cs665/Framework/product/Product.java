package com.cs665.Framework.product;

import com.cs665.Framework.order.OrderComponent;
import com.cs665.Framework.utils.MoneyUtils;
import com.cs665.productProperties.ProductColor;
import com.cs665.utils.MockIDGenerator;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public abstract class Product implements OrderComponent {
    protected String name;
    protected String serialNumber;
    protected int priceInCents;
    protected ProductColor color;

    public Product(String name, int priceInCents, ProductColor color) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.color = color;
        serialNumber = MockIDGenerator.generateNewProductSerial();
    }

    /*
     * Getters and Setters
     * Setter ONLY for priceInCents. Name, SerialNumber, ConnectionType
     * and Color are set at manufacture time and can't be changed
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriceInCents() {
        return priceInCents;
    }

    public ProductColor getColor() {
        return color;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "\n" + name + " - " + color + " - " + "SN: " + serialNumber + " - " + MoneyUtils.formatCentsToDollars(priceInCents);
    }

    public abstract Product clone();
}
