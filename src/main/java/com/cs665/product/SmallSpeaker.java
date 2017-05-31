package com.cs665.product;

import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public class SmallSpeaker extends Product {
    public SmallSpeaker(ProductColor color) {
        super("Small Speaker", 19900, color);
    }

    @Override
    public Product clone() {
        Product newProduct = new SmallSpeaker(color);
        newProduct.serialNumber = this.serialNumber;
        return newProduct;
    }
}
