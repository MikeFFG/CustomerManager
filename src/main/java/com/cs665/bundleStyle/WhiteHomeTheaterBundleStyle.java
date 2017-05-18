package com.cs665.bundleStyle;

import com.cs665.bundle.Bundle;
import com.cs665.product.ProductList;
import com.cs665.product.SmallSpeaker;
import com.cs665.product.SoundBar;
import com.cs665.product.Subwoofer;

/**
 * Created by mburke on 5/16/17.
 */
public class WhiteHomeTheaterBundleStyle extends HomeTheaterBundleStyle {
    private static final String bundleName = "Home Theater Bundle - White";

    public Bundle getBundle() {
        ProductList products = new ProductList(new SmallSpeaker(), new SmallSpeaker(), new SoundBar(), new Subwoofer());
        return new Bundle(bundleName, getRetailValueInCents(), bundleDiscount, products);
    }

}
