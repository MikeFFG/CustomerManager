package com.cs665.bundle;

import com.cs665.Framework.bundle.Bundle;
import com.cs665.product.ProductFactory;

/**
 * Created by mburke on 5/18/17.
 */
public class HomeTheaterBundleFactory implements BundleFactory {
    @Override
    public Bundle createBundle(ProductFactory factory) {
        return new HomeTheaterBundle(factory);
    }
}
