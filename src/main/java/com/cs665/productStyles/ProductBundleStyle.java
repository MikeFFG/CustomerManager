package com.cs665.productStyles;

import com.cs665.products.Product;
import com.cs665.products.ProductColor;

import java.util.List;

/**
 * Created by mburke on 5/16/17.
 */
public interface ProductBundleStyle {
    List<Product> getProducts();
    ProductColor getProductColor();
    double getPrice();

//    ProductBundle getProductBundle();
}
