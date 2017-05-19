package com.cs665.main;

import java.util.Scanner;

import com.cs665.bundle.Bundle;
import com.cs665.bundle.DigitalStreamingBundleFactory;
import com.cs665.bundle.HomeTheaterBundleFactory;
import com.cs665.product.BlackProductFactory;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public class Main {
    public static void main(String[] args) {
        Bundle myBundle;
        Scanner sc = new Scanner(System.in);

        displayWelcomeMessage();

        System.out.println("Choose a bundle style by typing in the associated number. Your options are:");
        System.out.println("1. Digital Streaming Bundle");
        System.out.println("2. Home Theater Bundle");

        int choice = sc.nextInt();
        if (choice == 1) {
            myBundle = new DigitalStreamingBundleFactory().createBundle(new BlackProductFactory());
        } else {
            myBundle = new HomeTheaterBundleFactory().createBundle(new BlackProductFactory());
        }

        System.out.println(myBundle);
        displayGoodbyeMessage();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Sonos customer manager.");
    }

    private static void displayGoodbyeMessage() {
        System.out.println("Goodbye!");
    }
}
