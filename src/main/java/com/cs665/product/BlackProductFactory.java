package com.cs665.product;

import com.cs665.productProperties.ProductColor;

/**
 * @author michael.burke
 * @since 5/19/17
 */
public class BlackProductFactory implements ProductFactory {
    private final ProductColor color = ProductColor.BLACK;

    public Product getSmallSpeaker() {
        return new SmallSpeaker(color);
    }

    public Product getLargeSpeaker() {
        return new LargeSpeaker(color);
    }

    public Product getSoundBar() {
        return new SoundBar(color);
    }

    public Product getSubwoofer() {
        return new Subwoofer(color);
    }

    public Product getSurroundSpeaker() {
        return new SurroundSpeaker(color);
    }

    public ProductColor getColor() { return color; }
}
