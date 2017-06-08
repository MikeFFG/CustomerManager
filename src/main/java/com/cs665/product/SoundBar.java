package com.cs665.product;

import com.cs665.Framework.product.Product;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public class SoundBar extends Product {
    public SoundBar(ProductColor color) {
        super("Soundbar", 49900, color);
    }

    @Override
    public Product clone() {
        Product newProduct = new SoundBar(color);
        newProduct.serialNumber = this.serialNumber;
        return newProduct;
    }
}
