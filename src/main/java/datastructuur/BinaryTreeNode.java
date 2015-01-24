package datastructuur;

import pojo.Customer;

/**
 * Created by darryl on 24-1-15.
 */
class BinaryTreeNode {
    private Customer customer;
    private BinaryTreeNode parent, left, right;

    public BinaryTreeNode(Customer customer) {
        this.customer = customer;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BinaryTreeNode getParent() {
        return parent;
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
