package com.cs665.bundleStyle;

import com.cs665.bundle.Bundle;
import com.cs665.product.Product;
import com.cs665.product.ProductList;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public abstract class ProductBundleStyle {
    protected int retailValueInCents;
    protected double discountPercentage;
    protected String name;
    protected ProductList products;
    protected ProductColor bundleColor;

    public ProductBundleStyle() {}

    public ProductBundleStyle(Product... products) {
        for (Product product : products) {
            this.products.add(product);
        }
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

    public abstract Bundle getBundle();
}
