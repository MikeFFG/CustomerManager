package com.cs665.Framework.bundle;

import com.cs665.bundle.classes.TestBundle;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author michael.burke
 * @since 5/19/17
 */
public class BundleTest {
    @Test
    public void test_positive_calculateRetailValueInCents() {
        Bundle bundle = new TestBundle();
        Assert.assertEquals(10000, bundle.calculateRetailValueInCents());
    }

    @Test
    public void test_positive_calculatePriceInCents() {
        Bundle bundle = new TestBundle();
        Assert.assertEquals(7500, bundle.calculatePriceInCents());
    }
}
