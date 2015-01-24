/**
 * Created by Wouter on 1/24/2015.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pojo.Customer;
import pojo.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScenarioInitializer {
    public static final String JSON_KLANT = "./data/klant.json";

    public String readContents(String filename) {
        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            fileReader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    public List getCustomers(String jsonString) {
        List<Customer> res = new ArrayList<Customer>();
        JSONObject obj;
        try {
            obj = new JSONObject(jsonString);
            JSONArray jsonArray = obj.getJSONArray("klanten");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentObject = jsonArray.getJSONObject(i);
                Customer customer = new Customer(
                        currentObject.getInt("id"),
                        currentObject.getInt("leeftijd"),
                        currentObject.getString("voornaam"),
                        currentObject.getString("tussenvoegsel"),
                        currentObject.getString("achternaam"),
                        currentObject.getString("geslacht"),
                        currentObject.getString("plaats"),
                        currentObject.getString("email")
                );
                res.add(customer);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List getOrders(List customers) {
        List<Order> orders = new ArrayList<Order>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Customer randomCustomer = (Customer) customers.get(random.nextInt());
            Integer wait = random.nextInt(40) + 10;
            Order order = new Order(i, randomCustomer.getId(), wait);
            orders.add(order);
        }
        return orders;
    }
}
