/**
 * Created by Wouter on 1/24/2015.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pojo.Customer;
import pojo.Order;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class ScenarioInitializer {
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

    public Customer[] getCustomers(String jsonString) {
        Customer[] res = new Customer[0];
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
                res = Arrays.copyOf(res, res.length + 1);
                res[i] = customer;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Order[] getOrders(Customer[] customers) {
        Order[] res = new Order[50];
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Customer randomCustomer = customers[random.nextInt(customers.length - 1)];
            Integer wait = random.nextInt(20) + 10;
            Order order = new Order(i, randomCustomer.getId(), wait);
            res[i] = order;
        }
        return res;
    }

    public static void main(String[] args) {
        new ScenarioInitializer();
    }
}
