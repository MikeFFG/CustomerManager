package com.cs665.main;

import com.cs665.analytics.Dashboard;
import com.cs665.bundle.*;
import com.cs665.order.*;
import com.cs665.product.*;
import com.cs665.productProperties.ProductColor;
import com.cs665.undohistory.AddItemCommand;
import com.cs665.undohistory.Command;
import com.cs665.undohistory.HistoryManager;
import com.cs665.utils.OrderDB;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author michael.burke
 * @since 5/16/17
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static HistoryManager history = new HistoryManager();
    private static OrderDB orderDB = OrderDB.getOrderDB();
    private static boolean analyticsMode = false;
    private static Dashboard allTimeDashboard = new Dashboard(LocalDateTime.now().minusYears(100));
    private static Dashboard oneMonthDashboard = new Dashboard(LocalDateTime.now().minusMonths(1));

    public static void main(String[] args) {
        OrderList orderList = new OrderList();

        initializeDummyData();

        displayWelcomeMessage();

        System.out.println("Would you like to view our analytics boards as you go? 1 for yes. 2 for no");
        if (sc.nextInt() == 1) { analyticsMode = true; }

        if (analyticsMode == true) {
            displayDashboards();
        }

        // Single Order Loop
        while (true) {
            System.out.println("Choose from the following items by number. " +
                    "Enter 0 to finish order.\nEnter -1 for \"Undo\" (to remove the last item you added).");
            displayProductList();
            orderList.add(getUserOrderChoice());
            if (analyticsMode == true) {
                displayDashboards();
            }
            System.out.println("Would you like to add another order? 1 for yes. 2 for no");
            if (sc.nextInt() == 2) { break; }
            history.clear();
        }

        displayDefaultIterator(orderList);

        displayPriceIterator(orderList);

        displayGoodbyeMessage();
    }

    private static void displayDashboards() {
        System.out.println("All Time Dashboard:");
        System.out.println("Total Orders: " + allTimeDashboard.getTotalOrdersInDuration());
        System.out.println("Total Price: " + formatCentsToDollars(allTimeDashboard.getTotalPriceInDuration()) + "\n");
        System.out.println("One Month Dashboard:");
        System.out.println("Total Orders: " + oneMonthDashboard.getTotalOrdersInDuration());
        System.out.println("Total Price: " + formatCentsToDollars(oneMonthDashboard.getTotalPriceInDuration()) + "\n");
    }

    private static void initializeDummyData() {
        StandardOrder order1 = new StandardOrder();
        order1.addItem(new LargeSpeaker(ProductColor.BLACK));
        order1.addItem(new LargeSpeaker(ProductColor.BLACK));
        order1.addItem(new LargeSpeaker(ProductColor.BLACK));
        order1.setOrderTime( LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));
        orderDB.getAll().add(order1);

        StandardOrder order2 = new StandardOrder();
        order2.addItem(new LargeSpeaker(ProductColor.OAK));
        order2.setOrderTime( LocalDateTime.of(1990, Month.APRIL, 15, 11, 30));
        orderDB.getAll().add(order2);

        StandardOrder order3 = new StandardOrder();
        order3.addItem(new LargeSpeaker(ProductColor.WHITE));
        order3.addItem(new SurroundSpeaker(ProductColor.WHITE));
        order3.setOrderTime( LocalDateTime.of(2000, Month.APRIL, 15, 11, 30));
        orderDB.getAll().add(order3);

        StandardOrder order4 = new StandardOrder();
        order4.addItem(new SmallSpeaker(ProductColor.BLACK));
        order4.setOrderTime( LocalDateTime.of(1989, Month.APRIL, 15, 11, 30));
        orderDB.getAll().add(order4);
    }

    private static Order getUserOrderChoice() {
        Order order = new StandardOrder();
        // Add Product to Order
        while (true) {
            int userChoice = sc.nextInt();
            if (userChoice == 0) {
                break;
            } else if (userChoice == -1) {
                history.undo();
            } else {
                Command cmd = new AddItemCommand(order, parseUserChoice(userChoice));
                history.execute(cmd);
            }
        }
        return order;
    }

    private static OrderComponent parseUserChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                return new SmallSpeaker(ProductColor.BLACK);
            case 2:
                return new SurroundSpeaker(ProductColor.BLACK);
            case 3:
                return new SoundBar(ProductColor.BLACK);
            case 4:
                return new Subwoofer(ProductColor.BLACK);
            case 5:
                return new LargeSpeaker(ProductColor.BLACK);
            case 6:
                return new DigitalStreamingBundle(new BlackProductFactory());
            case 7:
                return new HomeTheaterBundle(new BlackProductFactory());
            default:
                throw new IllegalArgumentException("Invalid Choice.");
        }
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

    private static void displayDefaultIterator(OrderList orderList) {
        System.out.println("------------------------------------------------");
        System.out.println("Here is a list of your orders in default order:");
        OrderListIterator defaultIterator = orderList.createIteratorDefault();
        while (!defaultIterator.isDone()) {
            Order order = defaultIterator.getCurrentItem();
            for (OrderComponent item : order.getItems()) {
                System.out.println(item);
            }
            System.out.println("\nTotal for order = " + formatCentsToDollars(order.getTotalPriceInCents()));
            System.out.println("------------------------------------------------");
        }
    }

    private static void displayPriceIterator(OrderList orderList) {
        System.out.println("------------------------------------------------");
        System.out.println("Here is a list of your orders in price order:");
        OrderListIterator priceIterator = orderList.createIteratorByPrice();
        while (!priceIterator.isDone()) {
            Order order = priceIterator.getCurrentItem();
            for (OrderComponent item : order.getItems()) {
                System.out.println(item);
            }
            System.out.println("\nTotal for order = " + formatCentsToDollars(order.getTotalPriceInCents()));
            System.out.println("------------------------------------------------");
        }
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
