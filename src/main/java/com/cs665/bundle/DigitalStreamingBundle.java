package com.cs665.bundle;

import com.cs665.Framework.product.Product;
import com.cs665.product.ProductFactory;
import com.cs665.utils.MockIDGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/18/17.
 */
public class DigitalStreamingBundle extends CustomerManagerBundle {
    public DigitalStreamingBundle(ProductFactory factory) {
        this.factory = factory;
        this.name = "Digital Streaming Bundle";
        this.discountPercentage = 0.30;
        this.products = createProductsList();
        this.retailValueInCents = calculateRetailValueInCents();
        this.priceInCents = calculatePriceInCents();
        serialNumber = MockIDGenerator.generateNewProductSerial();
    }

    @Override
    protected List<Product> createProductsList() {
        List<Product> list = new ArrayList<Product>();
        list.add(factory.getSmallSpeaker());
        list.add(factory.getSmallSpeaker());
        list.add(factory.getSmallSpeaker());
        return list;
    }
}
