import datastructuur.Printer;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Customer;
import pojo.Order;

import static pojo.Constants.JSON_KLANT;

/**
 * Created by darryl on 24-1-15.
 */
public class TestScenario1 {
    private Customer[] customers;
    private Order[] orders;

    @org.junit.Before
    public void setUp() throws Exception {
        ScenarioInitializer initializer = new ScenarioInitializer();
        String jsonString = initializer.readContents(JSON_KLANT);
        customers = initializer.getCustomers(jsonString);
        orders = initializer.getOrders(customers);
    }

    @Test
    public void testPrinterInit() throws Exception {
        new Printer();
    }

    @Test
    public void testPrinterQueue() throws Exception {
        Printer p = new Printer();
        assertTrue(p.hasNoOrders());
        p.placeOrder(orders[0]);
        p.placeOrder(orders[1]);
        p.placeOrder(orders[2]);
        assertEquals(p.getOrdersAmount(), 3);
        assertTrue(p.getCurrentOrder().isCurrentlyProcessing());
    }

    @Test
    public void testPrinterDequeue() throws Exception {
        int delayInSecs = 5;
        Printer p = new Printer();
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