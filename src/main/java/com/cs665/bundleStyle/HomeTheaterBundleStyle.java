package com.cs665.bundleStyle;

import com.cs665.bundle.Bundle;
import com.cs665.product.ProductList;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public abstract class HomeTheaterBundleStyle extends ProductBundleStyle {
    private static final int retailValueInCents = 7990;
    private static final double discountPercentage = 0.25;

    public HomeTheaterBundleStyle(String name, ProductColor bundleColor, ProductList products) {
        super(retailValueInCents, discountPercentage, name, bundleColor, products);
    }

    public abstract Bundle getBundle();
}
