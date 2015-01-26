package logic;

import pojos.Order;

/**
 * Created by darryl on 26-1-15.
 */
public class PrintQueueAssignment {
    private PrintQueue slowQueue, fastQueue;

    public PrintQueueAssignment() {
        this.slowQueue = new PrintQueue();
        this.fastQueue = new PrintQueue();
    }

    public void processOrder(Order order) {
        if (order.isCustomerWaiting()) {
            slowQueue.placeOrder(order);
        } else {
            fastQueue.placeOrder(order);
        }
    }

    public PrintQueue getSlowQueue() {
        return slowQueue;
    }

    public PrintQueue getFastQueue() {
        return fastQueue;
    }
}
