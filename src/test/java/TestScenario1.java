import logic.PrintQueue;
import logic.PrintQueueAssignment;
import org.junit.Test;
import pojos.Customer;
import pojos.Order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by darryl on 24-1-15.
 */
public class TestScenario1 {
    private Order[] orders;

    @org.junit.Before
    public void setUp() throws Exception {
        final String JSON_KLANT = "./data/klant.json";
        TestSetup initializer = new TestSetup();
        String jsonString = initializer.readContents(JSON_KLANT);
        Customer[] customers = initializer.getCustomers(jsonString);
        orders = initializer.getOrders(customers);
    }

    @Test
    public void testPrinterInit() throws Exception {
        new PrintQueue();
        new PrintQueueAssignment();
    }

    @Test
    public void testPrinterQueue() throws Exception {
        PrintQueue p = new PrintQueue();
        assertTrue(p.hasNoOrders());
        p.placeOrder(orders[0]);
        p.placeOrder(orders[1]);
        p.placeOrder(orders[2]);
        assertEquals(p.getOrdersAmount(), 3);
        assertTrue(p.getCurrentOrder().isCurrentlyProcessing());
    }

    @Test
    public void testPrinterAssignment() {
        PrintQueueAssignment printQueueAssignment = new PrintQueueAssignment();
        for (Order order : orders) {
            printQueueAssignment.processOrder(order);
        }
        Order fastOrder = printQueueAssignment.getFastQueue().getCurrentOrder();
        Order slowOrder = printQueueAssignment.getSlowQueue().getCurrentOrder();
        assertTrue(fastOrder.isCurrentlyProcessing());
        assertTrue(slowOrder.isCurrentlyProcessing());
    }

    @Test
    public void testPrinterDequeue() throws Exception {
        int delayInSecs = 5;
        PrintQueue p = new PrintQueue();
        p.placeOrder(new Order(0, 0, delayInSecs));
        p.placeOrder(new Order(0, 0, delayInSecs));
        assertEquals(2, p.getOrdersAmount());
        Thread.sleep((delayInSecs) * 1000);
        p.updateOrder();
        p.finishOrder();
        assertEquals(1, p.getOrdersAmount());
        Thread.sleep((delayInSecs) * 1000);
        p.updateOrder();
        p.finishOrder();
        assertTrue(p.hasNoOrders());
    }
}