package com.cs665.bundle;

/**
 * Created by mburke on 5/18/17.
 */
public class HomeTheaterBundleFactory extends BundleFactory {
    @Override
    public static Bundle createBundle() {
        return new HomeTheaterBundle();
    }
}
