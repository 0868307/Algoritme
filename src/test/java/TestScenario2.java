import org.junit.Before;
import org.junit.Test;
import pojo.Customer;
import pojo.CustomerList;

import static org.junit.Assert.*;

/**
 * Created by darryl on 24-1-15.
 */
public class TestScenario2 {
    private CustomerList customers;

    @Before
    public void setUp() throws Exception {
        final String JSON_KLANT = "./data/klant.json";
        TestSetup initializer = new TestSetup();
        String jsonString = initializer.readContents(JSON_KLANT);
        Customer[] customersArray = initializer.getCustomers(jsonString);
        customers = new CustomerList();
        for (Customer customer : customersArray) {
            customers.add(customer);
        }
    }

    @Test
    public void testMergeSortAge() throws Exception {
        customers.shuffleArray(customers.getItems());
        customers.mergeSortByAge(customers.getItems());
        assertTrue(customers.get(0).getLeeftijd() < customers.get(1).getLeeftijd());
        assertTrue(customers.get(2).getLeeftijd() < customers.get(3).getLeeftijd());
    }

    @Test
    public void testLinearSearch() throws Exception {
        Customer found = customers.linearSearchByLeeftijd(16);
        Customer expected = new Customer(5, 16, "Kees", "Jan", "ISO", "M", "Nijmegen", "Keesjeboy@sjaak.nl");
        assertEquals(expected, found);

        found = customers.linearSearchByLeeftijd(4);
        assertEquals(null, found);
    }

    @Test
    public void testBinarySearch() throws Exception {
        customers.mergeSortByAge(customers.getItems());
        boolean expected = customers.binarySearch(customers.getItems(), 16);
        assertTrue("Value: " + expected, expected);

        expected = customers.binarySearch(customers.getItems(), 4);
        assertFalse(expected);
    }

    @Test
    public void testInsertionSort() throws Exception {
        customers.shuffleArray(customers.getItems());
        customers.insertionSortByAchternaam(customers.getItems());
        String[] expected = new String[]{
                "Amatsetam",
                "Blop",
                "Hoog",
                "ISO",
                "LOP",
                "Naloop"
        };

        int index = 0;
        for (Customer item : customers.getItems()) {
            assertEquals(expected[index], item.getAchternaam());
            index++;
        }
    }
}