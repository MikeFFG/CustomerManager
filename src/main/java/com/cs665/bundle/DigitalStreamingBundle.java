package com.cs665.bundle;

import com.cs665.product.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/18/17.
 */
public class DigitalStreamingBundle extends Bundle {
    public DigitalStreamingBundle() {
        this.bundleName = "Digital Streaming Bundle";
        this.discountPercentage = 0.30;
        this.products = createProductsList();
        this.retailValueInCents = calculateRetailValueInCents();
        this.priceInCents = calculatePriceInCents();
    }

    @Override
    protected List<Product> createProductsList() {
        List<Product> list = new ArrayList<Product>();
        list.add(new SmallSpeaker());
        list.add(new SmallSpeaker());
        list.add(new LargeSpeaker());
        return list;
    }
}
