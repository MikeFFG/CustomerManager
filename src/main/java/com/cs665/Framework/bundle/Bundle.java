package com.cs665.Framework.bundle;

import com.cs665.bundle.DigitalStreamingBundle;
import com.cs665.main.Main;
import com.cs665.Framework.order.OrderComponent;
import com.cs665.Framework.product.Product;
import com.cs665.product.ProductFactory;

import java.util.List;

/**
 * Created by mburke on 5/18/17.
 */
public abstract class Bundle implements OrderComponent {
    protected String name;
    protected String serialNumber;
    protected int priceInCents;
    protected int retailValueInCents;
    protected double discountPercentage;
    protected ProductFactory factory;
    protected List<Product> products;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriceInCents() {
        return priceInCents;
    }

    public int getRetailValueInCents() {
        return retailValueInCents;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ProductFactory getFactory() {
        return factory;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setFactory(ProductFactory factory) {
        this.factory = factory;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n" + name).
                append(" - " + factory.getColor()).
                append(" - " + Main.formatCentsToDollars(priceInCents)).
                append("\nIncluded Products: \n");
        for (Product product : products) {
            builder.append(product.toString());
        }
        return builder.toString();
    }

    /**
     * Uses the total MSRP value of the bundle times the discountPercentage to get the actual price of the bundle
     * @return - actual price of the bundle
     */
    protected int calculatePriceInCents() {
        return (int) Math.round(retailValueInCents * (1 - discountPercentage));
    }

    /**
     * Calculates the total "MSRP" of the bundle, by adding each product's price.
     * @return - the value of the bundle
     */
    protected int calculateRetailValueInCents() {
        int total = 0;
        for (Product product : products) {
            total += product.getPriceInCents();
        }
        return total;
    }

    public Bundle clone() {
        Bundle bundle = new DigitalStreamingBundle(factory);
        bundle.serialNumber = serialNumber;
        for (int i = 0; i < products.size(); i++) {
            bundle.products.set(i, products.get(i));
        }
        return new DigitalStreamingBundle(factory);
    }

    /**
     * Abstract method that creates the bundle. Each subclass should be aware of what
     * products are included in that particular bundle and will override this.
     * @return a List of products for the bundle
     */
    protected abstract List<Product> createProductsList();
}
