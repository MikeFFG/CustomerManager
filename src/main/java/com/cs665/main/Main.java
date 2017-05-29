package com.cs665.main;

import com.cs665.bundle.*;
import com.cs665.order.*;
import com.cs665.product.*;
import com.cs665.productProperties.ProductColor;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        displayWelcomeMessage();

        // Looping structure to be replaced in the future.
        // Just being used to test out and show IO functionality and Iterator
        // Hardcoding to black for ease of functionality

        // Single Order Loop
        while (true) {
            Order order = new StandardOrder();
            boolean keepGoing = true;
            // Add Product to Order
            while (keepGoing) {
                System.out.println("Choose from the following items by number. " +
                        "Enter 0 to finish order.\nEnter -1 for \"Undo\" (to remove the last item you added).");
                displayProductList();
                int userChoice = sc.nextInt();
                switch (userChoice) {
                    case -1:
                        System.out.println("Undo functionality not implemented. Enter again");
                        break;
                    case 0:
                        keepGoing = false;
                        break;
                    case 1:
                        order.addItem(new SmallSpeaker(ProductColor.BLACK));
                        break;
                    case 2:
                        order.addItem(new SurroundSpeaker(ProductColor.BLACK));
                        break;
                    case 3:
                        order.addItem(new SoundBar(ProductColor.BLACK));
                        break;
                    case 4:
                        order.addItem(new Subwoofer(ProductColor.BLACK));
                        break;
                    case 5:
                        order.addItem(new LargeSpeaker(ProductColor.BLACK));
                        break;
                    case 6:
                        order.addItem(new DigitalStreamingBundle(new BlackProductFactory()));
                        break;
                    case 7:
                        order.addItem(new HomeTheaterBundle(new BlackProductFactory()));
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
            orderList.add(order);
            System.out.println("Would you like to add another order? 1 for yes. 2 for no");
            int userChoice = sc.nextInt();
            if (userChoice == 2) {
                break;
            }
        }

        System.out.println("------------------------------------------------");
        System.out.println("Here is a list of your orders in default order:");
        OrderListIterator defaultIterator = orderList.createIteratorDefault();
        System.out.println();
        while (!defaultIterator.isDone()) {
            Order order = defaultIterator.getCurrentItem();
            System.out.print(order.getItems());
            System.out.println("------");
            System.out.println("Total for order = " + formatCentsToDollars(order.getTotalPriceInCents()));
            System.out.println("------------------------------------------------");
        }

        System.out.println("------------------------------------------------");
        System.out.println("Here is a list of your orders in price order:");
        OrderListIterator priceIterator = orderList.createIteratorByPrice();
        System.out.println();
        while (!priceIterator.isDone()) {
            Order order = priceIterator.getCurrentItem();
            System.out.print(order.getItems());
            System.out.println("------");
            System.out.println("Total for order = " + formatCentsToDollars(order.getTotalPriceInCents()));
            System.out.println("------------------------------------------------");
        }

        displayGoodbyeMessage();
    }

    private static void displayProductList() {
        System.out.println("1. Small Speaker - $199");
        System.out.println("2. Surround Speaker - $299");
        System.out.println("3. Soundbar - $499");
        System.out.println("4. Subwoofer - $499");
        System.out.println("5. Large Speaker - $799");
        System.out.println("6. Digital Streaming Bundle - $417.90");
        System.out.println("7. Home Theater Bundle - $1,495.50");
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Sonos customer manager.");
        System.out.println("Starting a new Order for you.");
    }

    private static void displayGoodbyeMessage() {
        System.out.println("\nGoodbye!");
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
