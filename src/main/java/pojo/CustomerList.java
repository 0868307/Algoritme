package pojo;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Wouter on 1/24/2015.
 */
public class CustomerList {
    private Customer[] items = new Customer[]{};
    public Customer get(int index)
    {
        return items[index];
    }
    public void add(Customer customer)
    {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length-1] = customer;
    }
    public void insertionSortByAchternaam(Customer[] itemlist)
    {
        for(int i=1;i<itemlist.length;i++)
        {
            Customer value = itemlist[i];
            int pos = i;
            while(pos>0 && itemlist[pos-1].getAchternaam().charAt(0) > value.getAchternaam().charAt(0))
            {
                Customer temp = itemlist[pos];
                itemlist[pos] = itemlist[pos-1];
                itemlist[pos-1] = temp;
                pos = pos-1;
            }
        }
    }
    public boolean binarySearch(Customer[] itemList, int leeftijd)
    {
        if(itemList.length == 0)
        {
            return false;
        }
        else {
            int midden = Math.round((itemList.length-1) / 2);
            if (itemList[midden].getLeeftijd() == leeftijd) {
                return true;
            } else if (itemList[midden].getLeeftijd() > leeftijd) {
                Customer[] left = new Customer[midden];
                System.arraycopy(itemList, 0, left, 0, midden);
                return binarySearch(left, leeftijd);
            } else {
                Customer[] right = new Customer[itemList.length - midden];
                System.arraycopy(itemList, midden+1, right, 0, midden+1);
                return binarySearch(right, leeftijd);
            }
        }
    }

    public Customer linearSearchByLeeftijd(int leeftijd )
    {
        for (Customer item : items) {
            if (item.getLeeftijd() == leeftijd) {
                return item;
            }
        }
        return null;
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

    public void mergeSortByAge(Customer[] itemlist)
    {
        if (itemlist.length > 1) {
            int middle = Math.round(itemlist.length / 2);
            Customer[] left = new Customer[middle];
            System.arraycopy(itemlist, 0, left, 0, middle);
            Customer[] right = new Customer[itemlist.length - middle];
            System.arraycopy(itemlist, middle, right, 0, itemlist.length - middle);
            mergeSortByAge(left);
            mergeSortByAge(right);

            int i=0,n=0,x=0;
            while(i < left.length && n < right.length)
            {
                if(left[i].getLeeftijd() < right[n].getLeeftijd()){
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

    public Customer[] getItems() {
        return items;
    }
}
