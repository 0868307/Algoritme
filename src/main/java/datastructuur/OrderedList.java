package datastructuur;

import pojo.Order;

import java.util.Arrays;

/**
 * Created by Wouter on 1/24/2015.
 */
public class OrderedList {
    private Order[] items = new Order[]{};
    public Order get(int index)
    {
        Order order = items[index];
        return order;
    }
    public void add(Order order)
    {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length-1] = order;
    }

    public Order[] getItems() {
        return items;
    }

    public void mergeSort()
    {
        printId();
        System.out.println("------");
        mergeSortById(getItems());
        printId();
    }
    public void printId()
    {
        for(int i=0;i<items.length;i++)
        {
            System.out.print(items[i].getId()+"-");
        }
    }

    public void mergeSortById(Order[] itemlist)
    {
        if (itemlist.length > 1) {
            int middle = (itemlist.length) / 2;
            Order[] left = new Order[middle];
            for (int a = 0; a < middle; a++) {
                left[a] = itemlist[a];
            }
            Order[] right = new Order[itemlist.length - middle];
            for (int b = 0; b < itemlist.length-middle; b++) {
                right[b] = itemlist[b+middle];
            }
            mergeSortById(left);
            mergeSortById(right);

            int i=0,n=0,x=0;

            while(i < left.length && n < right.length)
            {
                if(left[i].getId() < right[n].getId()){
                    items[x] = left[i];
                    i++;
                }else{
                    items[x] = right[n];
                    n++;
                }
                x++;
            }
            while(i< left.length)
            {
                items[x] = left[i];
                i++;
                x++;
            }
            while (n < right.length)
            {
                items[x] = right[n];
                n++;
                x++;
            }
        }

    }




}
