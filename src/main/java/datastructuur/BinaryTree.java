package datastructuur;

import pojo.Customer;

/**
 * Created by Wouter on 1/24/2015.
 */
public class BinaryTree {
    private BinaryTreeNode head = null;

    public BinaryTree(Customer[] customers) {
        for (Customer customer : customers) {
            addNode(customer);
        }
    }

    public BinaryTree addNode(Customer customer) {
        if (head == null) {
            head = new BinaryTreeNode(customer);
        } else {
            head.addChild(new BinaryTreeNode(customer));
        }
        return this;
    }
}