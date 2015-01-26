import adt.BinaryTree;
import org.junit.Before;
import org.junit.Test;
import pojos.Customer;

import java.util.Random;

/**
 * Created by darryl on 24-1-15.
 */
public class TestScenario3 {
    private Customer[] customers;

    @Before
    public void setUp() throws Exception {
        final String JSON_KLANT = "./data/klant.json";
        String jsonString = new TestSetup().readContents(JSON_KLANT);
        customers = new TestSetup().getCustomers(jsonString);
    }

    @Test
    public void testInitBtree() throws Exception {
        new BinaryTree("id");

    }

    @Test
    public void testAddNodeBtree() throws Exception {
        BinaryTree binaryTree = new BinaryTree("id");
        Customer c1 = new Customer(
                35,
                33,
                "Blikje",
                "met",
                "Taurine",
                "Metaal",
                "De tafel",
                "ditsmaaktlekker@bullit.com"
        );
        binaryTree.addNode(c1);
        for (Customer customer : customers) {
            binaryTree.addNode(customer);
        }
    }

    @Test
    public void testRemoveNodeBtree() throws Exception {
        BinaryTree binaryTree = new BinaryTree("id");
        for (Customer customer : customers) {
            binaryTree.addNode(customer);
        }
        Random random = new Random();
        Customer randomCustomer = customers[random.nextInt(customers.length - 1)];
        System.out.println("Random : "+randomCustomer);
        binaryTree.removeNode(randomCustomer);
        binaryTree.print();
    }
}