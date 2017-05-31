package com.cs665.product;

import com.cs665.productProperties.ProductColor;

/**
 * @author michael.burke
 * @since 5/19/17
 */
public class WhiteProductFactory implements ProductFactory {
    private final ProductColor color = ProductColor.WHITE;

    @Override
    public Product getSmallSpeaker() {
        return new SmallSpeaker(color);
    }

    @Override
    public Product getLargeSpeaker() {
        return new LargeSpeaker(color);
    }

    @Override
    public Product getSoundBar() {
        return new SoundBar(color);
    }

    @Override
    public Product getSubwoofer() {
        return new Subwoofer(color);
    }

    @Override
    public Product getSurroundSpeaker() {
        return new SurroundSpeaker(color);
    }

    @Override
    public ProductColor getColor() { return color; }

}
