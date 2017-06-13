package com.cs665.undohistory;

import com.cs665.Framework.order.Order;
import com.cs665.Framework.order.OrderComponent;
import com.cs665.order.StandardOrder;
import com.cs665.product.LargeSpeaker;
import com.cs665.product.SmallSpeaker;
import com.cs665.productProperties.ProductColor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mburke on 5/31/17.
 */
public class HistoryManagerTest {
    private AddItemCommand addItemCommand;
    private Order order;
    private HistoryManager historyManager;
    private OrderComponent firstItem;
    private OrderComponent secondItem;

    @Before
    public void setUp() {
        firstItem = new SmallSpeaker(ProductColor.OAK);
        secondItem = new LargeSpeaker(ProductColor.BLACK);
        order = new StandardOrder();
        historyManager = new HistoryManager();
    }

    @Test
    public void test_undo_functionality() {
        addItemCommand = new AddItemCommand(order, firstItem);
        historyManager.execute(addItemCommand);
        Assert.assertEquals(1, order.getItems().size());
        Assert.assertEquals(1, historyManager.getHistory().size());

        addItemCommand = new AddItemCommand(order, secondItem);
        historyManager.execute(addItemCommand);
        Assert.assertEquals(2, order.getItems().size());
        Assert.assertEquals(2, historyManager.getHistory().size());

        historyManager.undo();
        Assert.assertEquals(1, order.getItems().size());
        Assert.assertEquals(1, historyManager.getHistory().size());
    }
}
