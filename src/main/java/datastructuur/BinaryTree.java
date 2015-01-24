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
    public BinaryTree removeNode(Customer customer)
    {
        try {
            head.getNode(customer).remove();
        }catch (NullPointerException e)
        {
            e.printStackTrace();
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
        public BinaryTreeNode getNode(Customer customer)
        {
            int id = customer.getId();
            if(id < this.customer.getId()) {
                if(left.getValue() == customer )
                {
                    return left;
                }
                else{
                    left.getNode(customer);
                }
            }
            else if(id > this.customer.getId()) {
                if(right.getValue() == customer)
                {
                    return right;
                }
                else{
                    right.getNode(customer);
                }
            }
            return null;
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
        public void remove(){
            BinaryTreeNode lowest = this.right.getLastLeft();
            lowest.parent = parent;
            lowest.left = left;
            lowest.right = right;
            this.left.parent = lowest;
            this.right.parent = lowest;
            if(parent.left == this)
            {
                parent.left = lowest;
            }else if(parent.right == this){
                parent.right = lowest;
            }
        }
        public BinaryTreeNode getLastLeft(){
            if(this.left != null)
            {
                return this.left.getLastLeft();
            }else
            {
                return this;
            }
        }
        public String toString() {
            return ""+customer;
        }
    }
