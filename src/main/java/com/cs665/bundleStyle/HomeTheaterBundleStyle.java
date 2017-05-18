package com.cs665.bundleStyle;

import java.util.ArrayList;
import java.util.List;

import com.cs665.product.Product;

/**
 * Created by mburke on 5/16/17.
 */
public abstract class HomeTheaterBundleStyle extends ProductBundleStyle {
    protected static final double bundleDiscount = 0.25;
    protected List<Product> bundle = new ArrayList<Product>();

    public HomeTheaterBundleStyle(Product... products) {
        super(products);
    }


}