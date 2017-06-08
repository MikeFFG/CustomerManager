package com.cs665.product;

import com.cs665.Framework.product.Product;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/18/17.
 */
public class SurroundSpeaker extends Product {
    public SurroundSpeaker(ProductColor color) {
        super("SurroundSpeaker", 29900, color);
    }

    @Override
    public Product clone() {
        Product newProduct = new SurroundSpeaker(color);
        newProduct.setSerialNumber(this.serialNumber);
        return newProduct;
    }
}
