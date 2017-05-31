package com.cs665.bundle.classes;

import com.cs665.product.Product;
import com.cs665.productProperties.ProductColor;

/**
 * @author michael.burke
 * @since 5/19/17
 */
public class TestProduct extends Product {
    public TestProduct(String name, int priceInCents, ProductColor color) {
        super(name, priceInCents, color);
    }

    public Product clone() {
        return this;
    }
}
