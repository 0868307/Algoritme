package datastructuur;

import pojo.Bestelling;

import java.util.Arrays;

/**
 * Created by darryl on 24-1-15.
 */
public class Queue {
    private Bestelling[] orders = new Bestelling[]{};

    public Bestelling pop() {
        Bestelling res = orders[orders.length-1];
        orders = Arrays.copyOf(orders, orders.length - 1);
        return res;
    }

    public void append(Bestelling bestelling) {
        orders = Arrays.copyOf(orders, orders.length + 1);
        orders[0] = bestelling;
    }

    public int length() {
        return orders.length;
    }

    public boolean empty() {
        return orders.length == 0;
    }
}
