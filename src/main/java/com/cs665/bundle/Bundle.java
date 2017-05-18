package com.cs665.bundle;

import com.cs665.bundleStyle.ProductBundleStyle;
import com.cs665.product.ProductList;

/**
 * @author michael.burke
 * @since 5/18/17
 */
public class Bundle {
    private String bundleName;
    private int priceInCents;
    private int retailValueInCents;
    private double discountPercentage;
    private ProductList products;

//    /**
//     * Create new Bundle object
//     * @param bundleName - The name of the bundle
//     * @param retailValueInCents - The retail value of the bundle (i.e. the total price of the individual products summed)
//     * @param discountPercentage - The percentage of savings for the bundle
//     * @param products - The list of products included in the bundle
//     */
//    public Bundle(String bundleName, int retailValueInCents, double discountPercentage, ProductList products) {
//        this.bundleName = bundleName;
//        this.retailValueInCents = retailValueInCents;
//        this.discountPercentage = discountPercentage;
//        this.products = products;
//        setPrice();
//    }

    public Bundle(ProductBundleStyle style) {
        this.bundleName = style.getName();
        this.priceInCents = style.getRetailValueInCents();
        this.discountPercentage = style.getDiscountPercentage();
        this.products = style.getProducts();
        setPrice();
    }

    /*
     * Getters and Setters - there are use cases possible where a user
     * may need to alter parts of the Bundle after creation, for instance to give a
     * special discount, or a custom bundle, etc. so I've added setters.
     */

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public double getPrice() {
        return priceInCents;
    }

    public void setPrice(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public int getRetailValue() {
        return retailValueInCents;
    }

    public void setRetailValue(int retailValueInCents) {
        this.retailValueInCents = retailValueInCents;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public ProductList getProducts() {
        return products;
    }

    public void setProducts(ProductList products) {
        this.products = products;
    }

    /* Private Utilities */

    private void setPrice() {
        priceInCents = (int) Math.round(retailValueInCents * (1 - discountPercentage));
    }
}
