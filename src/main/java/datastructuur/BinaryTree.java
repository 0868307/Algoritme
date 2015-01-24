package datastructuur;

import pojo.Customer;

/**
 * Created by Wouter on 1/24/2015.
 */
public class BinaryTree {
    private BinaryTreeNode head = null;

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
        } else {
            head.addChild(new BinaryTreeNode(customer));
        }
        return this;
    }
}
class BinaryTreeNode {
        private Customer customer;
        private BinaryTreeNode parent,left,right;

        public BinaryTreeNode(Customer customer) {
            this.customer = customer;
        }

        public Customer getValue() {
            return customer;
        }

        public BinaryTreeNode addChild(BinaryTreeNode n) {
            int id = n.customer.getId();
            if(id < customer.getId()) {
                if (left != null) {
                    left.addChild(n);
                } else {
                    left = n;
                    parent = this;
                }
            }
            else if(id > customer.getId()) {
                if (right != null) {
                    right.addChild(n);
                } else {
                    right = n;
                    parent = this;
                }
            }
            return n;
        }
        public BinaryTreeNode removeChild(BinaryTreeNode n){
            return n;
        }
        public String toString() {
            return ""+customer;
        }
    }



