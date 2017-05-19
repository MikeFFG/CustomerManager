package com.cs665.bundle;

import java.util.ArrayList;
import java.util.List;

import com.cs665.product.Product;
import com.cs665.product.ProductFactory;

/**
 * Created by mburke on 5/18/17.
 */
public class HomeTheaterBundle extends Bundle {
    public HomeTheaterBundle(ProductFactory factory) {
        this.factory = factory;
        this.bundleName = "Home Theater Bundle";
        this.discountPercentage = 0.25;
        this.products = createProductsList();
        this.retailValueInCents = calculateRetailValueInCents();
        this.priceInCents = calculatePriceInCents();
    }

    @Override
    protected List<Product> createProductsList() {
        List<Product> list = new ArrayList<Product>();
        list.add(factory.getSubwoofer());
        list.add(factory.getSmallSpeaker());
        list.add(factory.getSmallSpeaker());
        list.add(factory.getSoundBar());
        list.add(factory.getSurroundSpeaker());
        list.add(factory.getSurroundSpeaker());
        return list;
    }
}
