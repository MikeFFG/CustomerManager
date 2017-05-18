package com.cs665.bundle;

import com.cs665.bundleStyle.ProductBundleStyle;
import com.cs665.product.ProductList;

/**
 * @author michael.burke
 * @since 5/18/17
 */
public class Bundle {
    private String bundleName;
    private double price;
    private double retailValue;
    private double discountPercentage;
    private ProductList products;

    /* Only one complete constructor for now. Don't see a use case for having a partial
     * or default constructor at this juncture.
     */

    /**
     * Create new Bundle object
     * @param bundleName - The name of the bundle
     * @param retailValue - The retail value of the bundle (i.e. the total price of the individual products summed)
     * @param discountPercentage - The percentage of savings for the bundle
     * @param products - The list of products included in the bundle
     */
    public Bundle(String bundleName, double retailValue, double discountPercentage, ProductList products) {
        this.bundleName = bundleName;
        this.retailValue = retailValue;
        this.discountPercentage = discountPercentage;
        this.products = products;
        setPrice();
    }

    public Bundle(ProductBundleStyle style) {
        this.bundleName = style.getName();
    }

    /* Getters and Setters */

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRetailValue() {
        return retailValue;
    }

    public void setRetailValue(double retailValue) {
        this.retailValue = retailValue;
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
        price = retailValue * (1 - discountPercentage);
    }
}
