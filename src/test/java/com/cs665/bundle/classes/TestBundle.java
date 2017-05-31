package com.cs665.bundle.classes;

import com.cs665.bundle.Bundle;
import com.cs665.order.OrderComponent;
import com.cs665.product.Product;
import com.cs665.productProperties.ProductColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michael.burke
 * @since 5/19/17
 */
public class TestBundle extends Bundle {
    public TestBundle() {
        this.name = "Test Bundle";
        this.discountPercentage = 0.25;
        this.products = createProductsList();
        this.retailValueInCents = calculateRetailValueInCents();
        this.priceInCents = calculatePriceInCents();
    }

    @Override
    protected List<Product> createProductsList() {
        List<Product> list = new ArrayList<Product>();
        for (int i = 0; i < 100; i++) {
            list.add(new TestProduct("Test Product", 100, ProductColor.BLACK));
        }
        return list;
    }

    public OrderComponent clone() {
        return this;
    }
}
