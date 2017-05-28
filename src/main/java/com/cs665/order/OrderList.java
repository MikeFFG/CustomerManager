package com.cs665.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/27/17.
 */
public class OrderList {
    private List<Order> orderList;

    public OrderList() {
        orderList = new ArrayList<>();
    }

    public OrderList(List<Order> orders) {
        orderList = new ArrayList<>(orders);
    }

    public OrderList(Order order) {
        orderList = new ArrayList<>();
        orderList.add(order);
    }

    public int size() {
        return orderList.size();
    }

    public Order get(int index) {
        return orderList.get(index);
    }

    public void add(Order order) {
        orderList.add(order);
    }

    /* Iterators */

    public OrderListIterator createIteratorDefault() {
        return new OrderListIteratorDefault(this);
    }

    public OrderListIterator createIteratorByDate() {
        return new OrderListIteratorByDate(this);
    }

    public OrderListIterator createIteratorByPrice() {
        return new OrderListIteratorByPrice(this);
    }

    /* Iterator nested classes
     * Copying Orders to a new list to preserve original list order.
     * NOT deep copying Orders.
     * Currently, sorting algorithms are pretty inefficient.
     * TODO: Sort more efficiently.
     */

    protected class OrderListIteratorDefault extends OrderListIterator {
        public OrderListIteratorDefault(OrderList list) {
            orderList = list;
            index = 0;
        }
    }

    protected class OrderListIteratorByDate extends OrderListIterator {
        public OrderListIteratorByDate(OrderList list) {
            orderList = createListByDate(list);
            index = 0;
        }

        private OrderList createListByDate(OrderList list) {
            List<Order> newList = new ArrayList<>();    // New List so we don't shift items in the old list
            List<Order> oldList = list.orderList;

            // Loop through original list
            for (int i = 0; i < oldList.size(); i++) {
                // If it's the first item, just add to the new list
                if (i == 0) {
                    newList.add(oldList.get(i));
                } else {
                    LocalDateTime current = oldList.get(i).getOrderTime();
                    int currentSize = newList.size();
                    int indexToAdd = currentSize;

                    // Loop through the new list
                    for (int j = 0; j < currentSize; j++) {
                        // Compare dates
                        if (newList.get(j).getOrderTime().isAfter(current)) {
                            indexToAdd = j;
                            break;
                        }
                    }
                    newList.add(indexToAdd, oldList.get(i));
                }
            }
            return new OrderList(newList);
        }
    }

    protected class OrderListIteratorByPrice extends OrderListIterator {
        public OrderListIteratorByPrice(OrderList list) {
            orderList = createListByDate(list);
            index = 0;
        }

        private OrderList createListByDate(OrderList list) {
            List<Order> newList = new ArrayList<>();    // New List so we don't shift items in the old list
            List<Order> oldList = list.orderList;

            // Loop through original list
            for (int i = 0; i < oldList.size(); i++) {
                // If it's the first item, just add to the new list
                if (i == 0) {
                    newList.add(oldList.get(i));
                } else {
                    int currentPrice = oldList.get(i).getTotalPriceInCents();
                    int currentSize = newList.size();
                    int indexToAdd = currentSize;

                    // Loop through the new list
                    for (int j = 0; j < currentSize; j++) {
                        // Compare price
                        if (newList.get(j).getTotalPriceInCents() > currentPrice) {
                            indexToAdd = j;
                            break;
                        }
                    }
                    newList.add(indexToAdd, oldList.get(i));
                }
            }
            return new OrderList(newList);
        }
    }
}
