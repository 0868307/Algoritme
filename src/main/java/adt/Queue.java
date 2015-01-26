package adt;

import java.util.Arrays;

/**
 * Created by darryl on 24-1-15.
 */
public class Queue<T>{
    private Object[] items;
    private int size = 0;
    public Queue(){
        items = new Object[size];
    }
    public T dequeue() {
        T res = (T)items[0];
        System.arraycopy(items, 1, items, 0, items.length-1);
        return res;
    }

    public void enqueue(T order) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length-1] = order;
        size = items.length;
    }

    public int length() {
        return items.length;
    }

    public boolean empty() {
        return items.length == 0;
    }

}
