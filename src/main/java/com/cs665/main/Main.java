package com.cs665.main;

import com.cs665.bundle.BundleFactory;
import com.cs665.bundle.DigitalStreamingBundleFactory;
import com.cs665.bundle.HomeTheaterBundleFactory;
import com.cs665.product.BlackProductFactory;
import com.cs665.product.OakProductFactory;
import com.cs665.product.ProductFactory;
import com.cs665.product.WhiteProductFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

//        Bundle bundle;
//        BundleFactory bundleFactory;
//        ProductFactory productFactory;
//
//        displayWelcomeMessage();
//
//        bundleFactory = getUserBundleChoice();
//        productFactory = getUserColorChoice();
//        bundle = bundleFactory.createBundle(productFactory);
//
//        System.out.println("You chose: \n" + bundle);
//        displayGoodbyeMessage();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Sonos customer manager.");
    }

    private static void displayGoodbyeMessage() {
        System.out.println("Goodbye!");
    }

    private static BundleFactory getUserBundleChoice() {
        System.out.println("Choose a bundle style by typing in the associated number. Your options are:");
        System.out.println("1. Digital Streaming Bundle");
        System.out.println("2. Home Theater Bundle");
        int bundleType = 0;
        try {
            bundleType = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice");
            e.printStackTrace();
        }

        if (bundleType == 1) {
            return new DigitalStreamingBundleFactory();
        } else if (bundleType == 2){
            return new HomeTheaterBundleFactory();
        } else {
            throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static ProductFactory getUserColorChoice() {
        System.out.println("Choose a color: ");
        System.out.println("1. Black");
        System.out.println("2. White");
        System.out.println("3. Oak");
        int color = 0;
        try {
            color = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Choice");
            e.printStackTrace();
        }

        switch (color) {
            case 1:
                return new BlackProductFactory();
            case 2:
                return new WhiteProductFactory();
            case 3:
                return new OakProductFactory();
            default:
                throw new IllegalArgumentException("Invalid Choice");
        }
    }
}
