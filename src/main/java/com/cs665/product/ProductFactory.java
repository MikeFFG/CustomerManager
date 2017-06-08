package com.cs665.product;

import com.cs665.Framework.product.Product;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/18/17.
 */
public interface ProductFactory {
    Product getSmallSpeaker();

    Product getLargeSpeaker();

    Product getSoundBar();

    Product getSubwoofer();

    Product getSurroundSpeaker();

    ProductColor getColor();
}
