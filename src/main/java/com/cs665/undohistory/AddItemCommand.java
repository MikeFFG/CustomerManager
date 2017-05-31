package com.cs665.undohistory;

import com.cs665.order.Order;
import com.cs665.order.OrderComponent;

/**
 * Created by mburke on 5/31/17.
 */
public class AddItemCommand extends Command {
    private Order postState;
    private Order previousState;

    public AddItemCommand(Order order, OrderComponent item) {
        order.addItem(item);
    }

    public void execute() {}
    public void undo() {}
}
