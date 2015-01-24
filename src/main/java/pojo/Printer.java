package pojo;

import datastructuur.Queue;
import pojo.Order;

/**
 * Created by darryl on 24-1-15.
 */
public class Printer {
    private Queue orders;
    private Order currentOrder;

    public Printer() {
        this.orders = new Queue();
    }

    // Customer maakt een nieuwe order aan wordt gelijk afgehandeld OF
    // wordt aan bestaande orders toegevoegd indien er al een order staat
    public void placeOrder(Order order) {
        boolean isFree = orders.empty() && currentOrder == null ||
                !currentOrder.isCurrentlyProcessing();
        if (isFree) {
            currentOrder = order;
            currentOrder.setCurrentlyProcessing(true);
        } else {
            orders.enqueue(order);
        }
    }

    public void finishOrder() {
        if (currentOrder!= null && currentOrder.isComplete()) {
            if (!orders.empty()) {
                currentOrder = orders.dequeue();
            } else {
                currentOrder.setCurrentlyProcessing(false);
            }
        }
    }

    public void updateOrder() {
        Long now = System.currentTimeMillis();
        long startMin = currentOrder.getStartTime();
        long orderMin = currentOrder.getMaxProcessingTime().getTime();
        boolean pastMaxWaitingTime = now - startMin > orderMin;
        if (pastMaxWaitingTime) {
            currentOrder.setComplete(true);
        }
    }

    public int getOrdersAmount() {
        int length = orders.length();
        if (currentOrder != null && currentOrder.isCurrentlyProcessing()) {
            length += 1;
        }
        return length;
    }

    public boolean hasNoOrders() {
        return orders.empty() && currentOrder == null ||
                !currentOrder.isCurrentlyProcessing();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
