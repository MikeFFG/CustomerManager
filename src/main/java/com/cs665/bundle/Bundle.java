package com.cs665.bundle;

import java.text.NumberFormat;
import java.util.List;

import com.cs665.product.Product;
import com.cs665.product.ProductFactory;

/**
 * Created by mburke on 5/18/17.
 */
public abstract class Bundle {
    protected String bundleName;
    protected int priceInCents;
    protected int retailValueInCents;
    protected double discountPercentage;
    protected ProductFactory factory;
    protected List<Product> products;

    protected Bundle() {}

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

    public String formatCentsToDollars(int value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(value / 100);
    }

    public ProductFactory getFactory() {
        return factory;
    }

    public void setFactory(ProductFactory factory) {
        this.factory = factory;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n" + bundleName).
                append(" - " + factory.getColor()).
                append(" - " + formatCentsToDollars(priceInCents)).
                append("\nIncluded Products: \n");
        for (Product product : products) {
            builder.append(product.toString());
        }
        builder.append("\n");
        return builder.toString();
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
