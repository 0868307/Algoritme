package datastructuur;

import pojo.Customer;
import pojo.Order;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Wouter on 1/24/2015.
 */
public class CustomerList {
    private Customer[] items = new Customer[]{};
    public Customer get(int index)
    {
        Customer customer = items[index];
        return customer;
    }
    public int length()
    {
        return items.length;
    }
    public void add(Customer customer)
    {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length-1] = customer;
    }

    public Customer[] getItems() {
        return items;
    }

    public void mergeSort()
    {
        shuffleArray(items);
        mergeSortById(items);
    }

    // shuffle function is from http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    public void shuffleArray(Customer[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Customer a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public void mergeSortById(Customer[] itemlist)
    {
        if (itemlist.length > 1) {
            int middle = Math.round(itemlist.length / 2);
            Customer[] left = new Customer[middle];
            for (int a = 0; a < middle; a++) {
                left[a] = itemlist[a];
            }
            Customer[] right = new Customer[itemlist.length - middle];
            for (int b = 0; b < itemlist.length-middle; b++) {
                right[b] = itemlist[b+middle];
            }
            mergeSortById(left);
            mergeSortById(right);

            int i=0,n=0,x=0;
            while(i < left.length && n < right.length)
            {
                if(left[i].getId() < right[n].getId()){
                    itemlist[x] = left[i];
                    i = i+1;
                }else{
                    itemlist[x] = right[n];
                    n = n+1;
                }
                x = x +1;
            }
            while(i< left.length)
            {
                itemlist[x] = left[i];
                i= i+1;
                x = x+1;
            }
            while (n < right.length)
            {
                itemlist[x] = right[n];
                n= n+1;
                x = x+1;
            }
        }
    }




}
