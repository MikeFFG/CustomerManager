package com.cs665.order;

/**
 * Interface that needs to be implemented by any item
 * that is going to be added to an Order. Currently, Bundles and Products
 * Created by mburke on 5/28/17.
 */
public interface OrderComponent {
    int getPriceInCents();

    String getName();

    String getSerialNumber();

    void setSerialNumber(String serialNumber);

    OrderComponent clone();
}
