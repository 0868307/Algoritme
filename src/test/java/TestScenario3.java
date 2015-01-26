import adt.BinaryTree;
import org.junit.Test;
import pojos.Customer;

/**
 * Created by darryl on 24-1-15.
 */
public class TestScenario3 {
    @Test
    public void testInitBtree() throws Exception {
        new BinaryTree("id");
    }

    @Test
    public void testAddNodeBtree() throws Exception {
        BinaryTree binaryTree = new BinaryTree("id");
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
        BinaryTree binaryTree = new BinaryTree("id");
    }
}