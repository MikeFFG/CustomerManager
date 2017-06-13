package com.cs665.Framework.utils;

import java.text.NumberFormat;

/**
 * Created by mburke on 6/8/17.
 */
public class MoneyUtils {
    /**
     * Due to issues with floating point numbers, we are storing cents as ints.
     * Need to convert to dollars for display purposes
     * @param cents - value of cents to convert
     * @return - String formatted in dollars
     */
    public static String formatCentsToDollars(int cents) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cents / 100.0);
    }
}
