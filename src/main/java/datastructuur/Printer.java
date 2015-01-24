package datastructuur;

import datastructuur.Queue;
import pojo.Order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        System.out.println("Nieuwe order wordt geplaatst");
        boolean isFree = orders.empty() && !currentOrder.isCurrentlyProcessing();
        if (isFree) {
            currentOrder = order;
            currentOrder.setCurrentlyProcessing(true);
        } else {
            orders.enqueue(order);
        }
    }

    public void removeOrder() {
        if (currentOrder.isComplete()) {
            System.out.println("Oude order wordt verwijderd");
            System.out.println("Nieuwe order wordt verwerkt");
            currentOrder = orders.dequeue();
            currentOrder.setCurrentlyProcessing(true);
        }
    }

    public void updateOrder() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        Date now = Calendar.getInstance().getTime();
        Integer nowMin = Integer.valueOf(sdf.format(now));
        Integer startMin = Integer.valueOf(sdf.format(currentOrder.getStartTime()));
        boolean pastMaxWaitingTime = nowMin - startMin > currentOrder.getMaxProcessingTime();
        if (pastMaxWaitingTime) {
            currentOrder.setComplete(true);
            removeOrder();
        }
    }
}
