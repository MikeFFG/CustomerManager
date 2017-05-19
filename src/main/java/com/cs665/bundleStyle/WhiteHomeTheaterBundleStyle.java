package com.cs665.bundleStyle;

import com.cs665.product.ProductList;
import com.cs665.product.SmallSpeaker;
import com.cs665.product.SoundBar;
import com.cs665.product.Subwoofer;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public class WhiteHomeTheaterBundleStyle extends HomeTheaterBundleStyle {
    private static final String name = "Home Theater Bundle - White";
    private static final ProductColor bundleColor = ProductColor.WHITE;
    private static final ProductList productList = new ProductList(new SoundBar(),
            new SmallSpeaker(), new SmallSpeaker(), new Subwoofer());

    public WhiteHomeTheaterBundleStyle() {
        super(name, bundleColor, productList);
    }
}
