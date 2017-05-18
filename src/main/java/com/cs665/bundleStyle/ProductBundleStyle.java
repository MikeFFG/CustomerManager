package com.cs665.bundleStyle;

import java.util.List;

import com.cs665.product.Product;
import com.cs665.productProperties.ProductColor;

/**
 * Created by mburke on 5/16/17.
 */
public interface ProductBundleStyle {
    List<Product> getProducts();
    ProductColor getProductColor();
    double getPrice();

//    ProductBundle getProductBundle();
}
