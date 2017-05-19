package com.cs665.bundle;

import com.cs665.product.ProductFactory;

/**
 * Created by mburke on 5/18/17.
 */
public interface BundleFactory {
    Bundle createBundle(ProductFactory factory);
}
