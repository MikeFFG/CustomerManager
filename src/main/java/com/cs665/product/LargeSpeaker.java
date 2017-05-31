package com.cs665.product;

import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/18/17.
 */
public class LargeSpeaker extends Product {
    public LargeSpeaker(ProductColor color) {
        super("Large Speaker", 79900, color);
    }

    @Override
    public Product clone() {
        Product newProduct = new LargeSpeaker(color);
        newProduct.serialNumber = this.serialNumber;
        return newProduct;
    }
}
