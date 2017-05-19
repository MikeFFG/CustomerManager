package com.cs665.bundle;

import com.cs665.product.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/18/17.
 */
public class HomeTheaterBundle extends Bundle {
    public HomeTheaterBundle() {
        this.bundleName = "Home Theater Bundle";
        this.discountPercentage = 0.25;
        this.products = createProductsList();
        this.retailValueInCents = calculateRetailValueInCents();
        this.priceInCents = calculatePriceInCents();
    }

    @Override
    protected List<Product> createProductsList() {
        List<Product> list = new ArrayList<Product>();
        list.add(new Subwoofer());
        list.add(new SmallSpeaker());
        list.add(new SmallSpeaker());
        list.add(new SoundBar());
        list.add(new SurroundSpeaker());
        list.add(new SurroundSpeaker());
        return list;
    }
}
