package com.cs665.undohistory;

import com.cs665.Framework.order.Order;
import com.cs665.Framework.order.OrderComponent;

/**
 * Created by mburke on 5/31/17.
 */
public class AddItemCommand extends Command {
    private OrderComponent item;
    private Order order;

    public AddItemCommand(Order order, OrderComponent item) {
        this.item = item;
        this.order = order;
    }

    @Override
    public void execute() {
        order.addItem(item);
    }

    @Override
    public void undo() {
        order.removeItem(item);
    }
}
