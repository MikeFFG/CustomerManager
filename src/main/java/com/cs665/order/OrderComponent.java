package com.cs665.order;

/**
 * Created by mburke on 5/28/17.
 */
public interface OrderComponent {
    int getPriceInCents();

    String getName();

    String getSerialNumber();

    void setSerialNumber(String serialNumber);

    OrderComponent clone();
}
