package com.cs665.bundle;

import com.cs665.Framework.bundle.Bundle;
import com.cs665.Framework.product.Product;
import com.cs665.product.ProductFactory;
import com.cs665.mockDB.MockIDGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/18/17.
 */
public class HomeTheaterBundle extends CustomerManagerBundle {
    public HomeTheaterBundle(ProductFactory factory) {
        this.factory = factory;
        this.name = "Home Theater Bundle";
        this.discountPercentage = 0.25;
        this.products = createProductsList();
        this.retailValueInCents = calculateRetailValueInCents();
        this.priceInCents = calculatePriceInCents();
        serialNumber = MockIDGenerator.generateNewProductSerial();
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

    @Override
    public Bundle clone() {
        Bundle bundle = new HomeTheaterBundle(factory);
        bundle.getSerialNumber();
        for (int i = 0; i < products.size(); i++) {
            bundle.getProducts().set(i, products.get(i));
        }
        return new HomeTheaterBundle(factory);
    }
}
