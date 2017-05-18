package com.cs665.product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public class ProductList {
    private List<Product> productList;

    public ProductList() {
        productList = new ArrayList<Product>();
    }

    public void add(Product product) {
        productList.add(product);
    }
}
