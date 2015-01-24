package datastructuur;

import pojo.Bestelling;

import java.util.Arrays;

/**
 * Created by darryl on 24-1-15.
 */
public class Queue {
    private Bestelling[] orders = new Bestelling[]{};

    public Bestelling get() {
        Bestelling res = orders[orders.length-1];
        orders = Arrays.copyOf(orders, orders.length - 1);
        return res;
    }

    public void add(Bestelling bestelling) {
        orders = Arrays.copyOf(orders, orders.length + 1);
        orders[orders.length] = bestelling;
    }

    public int length() {
        return orders.length;
    }

    public boolean empty() {
        return orders.length == 0;
    }
}
