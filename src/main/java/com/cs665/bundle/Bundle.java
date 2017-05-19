package com.cs665.bundle;

import com.cs665.product.Product;

import java.util.List;

/**
 * Created by mburke on 5/18/17.
 */
public abstract class Bundle {
    protected String bundleName;
    protected int priceInCents;
    protected int retailValueInCents;
    protected double discountPercentage;
    protected List<Product> products;

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public int getRetailValueInCents() {
        return retailValueInCents;
    }

    public void setRetailValueInCents(int retailValueInCents) {
        this.retailValueInCents = retailValueInCents;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    protected int calculatePriceInCents() {
        return (int) Math.round(retailValueInCents * (1 - discountPercentage));
    }

    protected int calculateRetailValueInCents() {
        int total = 0;
        for (Product product : products) {
            total += product.getPriceInCents();
        }
        return total;
    }

    protected abstract List<Product> createProductsList();
}
