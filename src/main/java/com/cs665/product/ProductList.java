package com.cs665.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Wrapper for ArrayList<Product>, to expose only a limited
 * set of features for the client.
 *
 * @author michael.burke
 * @since 5/16/17
 */
public class ProductList implements Iterable {
    private List<Product> productList;

    public ProductList() {
        productList = new ArrayList<Product>();
    }

    public ProductList(Product... products) {
        for (Product product : products) {
            productList.add(product);
        }
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void add(Product... products) {
        for (Product product : products) {
            productList.add(product);
        }
    }

    public boolean remove(String serialNumber) {
        Iterator iter = productList.listIterator();
        while(iter.hasNext()) {
            if (((Product)iter.next()).getSerialNumber().equals(serialNumber)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    public boolean remove(Product product) {
        return productList.remove(product);
    }

    public boolean contains(Product product) {
        return productList.contains(product);
    }

    public Iterator<Product> listIterator() {
        return productList.listIterator();
    }

    public Iterator<Product> iterator() {
        return productList.iterator();
    }
}
