package com.cs665.product;

import com.cs665.Framework.product.Product;
import com.cs665.productProperties.ProductColor;

/**
 * @author michael.burke
 * @since 5/18/17
 */
public class Subwoofer extends Product {
    public Subwoofer(ProductColor color) {
        super("Subwoofer", 49900, color);
    }

    @Override
    public Product clone() {
        Product newProduct = new Subwoofer(color);
        newProduct.serialNumber = this.serialNumber;
        return newProduct;
    }
}
