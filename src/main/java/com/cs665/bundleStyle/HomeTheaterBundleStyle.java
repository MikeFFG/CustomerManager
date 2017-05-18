package com.cs665.bundleStyle;

import com.cs665.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/16/17.
 */
public abstract class HomeTheaterBundleStyle implements ProductBundleStyle {
    protected final double bundleDiscount = 0.25;
    protected List<Product> bundle = new ArrayList<Product>();

    protected double calculateBundlePrice() {
        double price = 0;
        for (Product product : bundle) { price += product.getPrice(); }
        return price * bundleDiscount;
    }
}
