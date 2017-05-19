package com.cs665.bundleStyle;

import com.cs665.bundle.Bundle;
import com.cs665.product.ProductList;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public abstract class ProductBundleStyle {
    protected int retailValueInCents;
    protected int priceInCents;
    protected double discountPercentage;
    protected String name;
    protected ProductColor bundleColor;
    protected ProductList products;

    public ProductBundleStyle(int retailValueInCents, double discountPercentage,
                              String name, ProductColor bundleColor, ProductList products) {
        this.retailValueInCents = retailValueInCents;
        this.discountPercentage = discountPercentage;
        this.name = name;
        this.bundleColor = bundleColor;
        this.products = products;
        this.priceInCents = calculatePriceInCents();
    }

    public ProductList getProducts() {
        return products;
    }

    public ProductColor getBundleColor() {
        return bundleColor;
    }

    public double getDiscountPercentage() { return discountPercentage; }

    public String getName() {
        return name;
    }

    public int getRetailValueInCents() {
        return retailValueInCents;
    }

    public int getPriceInCents() { return priceInCents; }

    public abstract Bundle getBundle();

    private int calculatePriceInCents() {
        return (int) Math.round(retailValueInCents * (1 - discountPercentage));
    }
}
