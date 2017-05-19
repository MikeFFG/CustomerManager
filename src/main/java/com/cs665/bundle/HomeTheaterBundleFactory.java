package com.cs665.bundle;

/**
 * Created by mburke on 5/18/17.
 */
public class HomeTheaterBundleFactory implements BundleFactory {
    @Override
    public Bundle createBundle() {
        return new HomeTheaterBundle();
    }
}
