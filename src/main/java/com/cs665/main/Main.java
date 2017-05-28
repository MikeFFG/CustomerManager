package com.cs665.main;

import com.cs665.bundle.BundleFactory;
import com.cs665.bundle.DigitalStreamingBundleFactory;
import com.cs665.bundle.HomeTheaterBundleFactory;
import com.cs665.order.MyIterator;
import com.cs665.order.Order;
import com.cs665.order.OrderList;
import com.cs665.order.StandardOrder;
import com.cs665.product.*;
import com.cs665.productProperties.ProductColor;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        OrderList newOrderList = new OrderList();

        Order order1 = new StandardOrder();
        order1.addItem(new LargeSpeaker(ProductColor.BLACK));
        newOrderList.add(order1);

        Order order2 = new StandardOrder();
        order2.addItem(new LargeSpeaker(ProductColor.OAK));
        newOrderList.add(order2);

        Order order3 = new StandardOrder();
        order3.addItem(new LargeSpeaker(ProductColor.WHITE));
        newOrderList.add(order3);

        Order order4 = new StandardOrder();
        order4.addItem(new SmallSpeaker(ProductColor.BLACK));
        newOrderList.add(order4);

        MyIterator<Order> iter = newOrderList.createIterator();
        while(!iter.isDone()) {
            System.out.println(iter.getCurrentItem().getItems());
        }


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
