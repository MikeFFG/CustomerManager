package com.cs665.bundle;

import com.cs665.product.Product;
import com.cs665.product.ProductFactory;

import java.text.NumberFormat;
import java.util.List;

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

    public String getBundleName() {
        return bundleName;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public int getRetailValueInCents() {
        return retailValueInCents;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ProductFactory getFactory() {
        return factory;
    }

    /* Only one Setter. Bundles should be immutable except for Color */
    public void setFactory(ProductFactory factory) {
        this.factory = factory;
    }

    /**
     * Due to issues with floating point numbers, we are storing cents as ints.
     * Need to convert to dollars for display purposes
     * @param cents - value of cents to convert
     * @return - String formatted in dollars
     */
    public String formatCentsToDollars(int cents) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cents / 100.0);
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

    /**
     * Uses the total MSRP value of the bundle times the discountPercentage to get the actual price of the bundle
     * @return - actual price of the bundle
     */
    protected int calculatePriceInCents() {
        return (int) Math.round(retailValueInCents * (1 - discountPercentage));
    }

    /**
     * Calculates the total "MSRP" of the bundle, by adding each product's price.
     * @return - the value of the bundle
     */
    protected int calculateRetailValueInCents() {
        int total = 0;
        for (Product product : products) {
            total += product.getPriceInCents();
        }
        return total;
    }

    /**
     * Abstract method that creates the bundle. Each subclass should be aware of what
     * products are included in that particular bundle and will override this.
     * @return a List of products for the bundle
     */
    protected abstract List<Product> createProductsList();

}
