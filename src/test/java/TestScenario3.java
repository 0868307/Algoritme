import datastructuur.BinaryTree;
import org.junit.Before;
import org.junit.Test;
import pojo.Customer;

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
        new BinaryTree();
    }

    @Test
    public void testAddNodeBtree() throws Exception {
        BinaryTree binaryTree = new BinaryTree();
        Customer c1 = new Customer(
                5,
                33,
                "Blikje",
                "met",
                "Taurine",
                "Metaal",
                "De tafel",
                "ditsmaaktlekker@bullit.com"
        );
        binaryTree.addNode(c1);
    }

    @Test
    public void testRemoveNodeBtree() throws Exception {
        BinaryTree binaryTree = new BinaryTree();

    }
}