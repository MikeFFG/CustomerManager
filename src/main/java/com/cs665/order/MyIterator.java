package com.cs665.order;

/**
 * Created by mburke on 5/27/17.
 */
public interface MyIterator <E> {
    void setToFirst();

    void increment();

    boolean isDone();

    E getCurrentItem();
}
