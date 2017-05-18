package com.cs665.bundleStyle;

import com.cs665.bundle.Bundle;
import com.cs665.product.*;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public class WhiteHomeTheaterBundleStyle extends HomeTheaterBundleStyle {
    private final String bundleName = "Home Theater Bundle - White";

    public WhiteHomeTheaterBundleStyle() {
        discountPercentage = 0.25;
        retailValue = 799.00;
        products = new ProductList();
        bundleColor = ProductColor.WHITE;
    }

    public WhiteHomeTheaterBundleStyle(Product... products) {
        super(products);
    }

    @Override
    public Bundle getBundle() {
        products.add(new SmallSpeaker());
        products.add(new SmallSpeaker());
        products.add(new SoundBar());
        products.add(new Subwoofer());

        return new Bundle(bundleName, getRetailValue(), discountPercentage, products);
    }

}
