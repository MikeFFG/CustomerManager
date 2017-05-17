package com.cs665.productStyles;

import com.cs665.products.PlayOne;
import com.cs665.products.Product;
import com.cs665.products.ProductColor;
import com.cs665.products.SoundBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/16/17.
 */
public class WhiteHomeTheaterBundleStyle extends HomeTheaterBundleStyle implements ProductBundleStyle {
    private final ProductColor color = ProductColor.WHITE;
    private final double price = 799.00;
    private List<Product> bundle = new ArrayList<Product>();

    public WhiteHomeTheaterBundleStyle() {
        bundle.add(new PlayOne());
        bundle.add(new PlayOne());
        bundle.add(new SoundBar());
    }

    @Override
    public List<Product> getProducts() {
        return bundle;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public ProductColor getProductColor() {
        return color;
    }

}
