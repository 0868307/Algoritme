package datastructuur;

import pojo.Order;

import java.util.Arrays;

/**
 * Created by darryl on 24-1-15.
 */
public class Queue {
    private Order[] items = new Order[]{};

    public Order dequeue() {
        Order res = items[0];
        System.arraycopy(items, 1, items, 0, items.length-1);
        return res;
    }

    public void enqueue(Order order) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length-1] = order;
    }

    public int length() {
        return items.length;
    }

    public boolean empty() {
        return items.length == 0;
    }
}
