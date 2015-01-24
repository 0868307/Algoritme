package datastructuur;

import pojo.Customer;

/**
 * Created by Wouter on 1/24/2015.
 */
public class BinaryTree {
    private BinaryTreeNode head = null;
    private BinaryTreeNode tail = null;
    private int length = 0;

    public BinaryTree() {
    }
    public BinaryTree(Customer[] customers) {
        for(int i=0;i<customers.length;i++) {
            addNode(customers[i]);
        }
    }

    public BinaryTree addNode(Customer customer) {
        if(head == null) {
            head = new BinaryTreeNode(customer);
            tail = head;
            length = 1;
        } else {
            tail = tail.addChild(new BinaryTreeNode(customer));
            length++;
        }
        return this;
    }

    public Customer get(int index) {
        if(index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            return head.getValue();
        } else if(index == length-1) {
            return tail.getValue();
        } else {
            BinaryTreeNode current = head;
            for(int i=1;i < index;i++) {
                current = current.next();
            }
            return current.getValue();
        }
    }

    public String toString() {
        String out = "[";
        BinaryTreeNode current = head;
        while(current.hasNext()) {
            out += current.toString();
            if(current != tail) {
                out += ", ";
            }
        }
        return out+"]";
    }
}
class BinaryTreeNode {
        private Customer customer;
        private BinaryTreeNode prev;
        private BinaryTreeNode next;

        public BinaryTreeNode(Customer customer) {
            this.customer = customer;
        }

        public Customer getValue() {
            return customer;
        }

        public BinaryTreeNode addChild(BinaryTreeNode n) {
            int leeftijd = n.customer.getId();
            if(leeftijd < n.customer.getLeeftijd())

            next = n;
            n.prev = this;
            return n;
        }

        public BinaryTreeNode next() {
            return next;
        }

        public BinaryTreeNode prev() {
            return next;
        }

        public String toString() {
            return ""+customer;
        }
        public boolean hasNext() {
            return next != null;
        }
    }



