package datastructuur;

import pojo.Customer;
import pojo.Pojo;

/**
 * Created by Wouter on 1/24/2015.
 */
public class BinaryTree {
    private BinaryTreeNode head = null;
    private String id;

    public BinaryTree(String id) {
        this.id = id;
    }

    public BinaryTree(Pojo[] object) {
        for(int i=0;i<object.length;i++) {
            addNode(object[i]);
        }
    }

    public BinaryTree addNode(Pojo object) {
        if(head == null) {
            head = new BinaryTreeNode(object,id);
        } else {
            head.addChild(new BinaryTreeNode(object,id));
        }
        return this;
    }
    public BinaryTree removeNode(Pojo object)
    {
        try {
            head.getNode(object).remove();
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        return this;
    }

}
class BinaryTreeNode {
        private Pojo object;
        private BinaryTreeNode parent,left,right;
        private String idString;


        public BinaryTreeNode(Pojo object, String idString) {
            this.object = object;
            this.idString = idString;
        }
        public BinaryTreeNode getNode(Pojo object)
        {
            int id = object.getInteger(idString);
            if(id < this.object.getInteger(idString)) {
                if(left.getValue() == object )
                {
                    return left;
                }
                else{
                    left.getNode(object);
                }
            }
            else if(id > this.object.getInteger(idString)) {
                if(right.getValue() == object)
                {
                    return right;
                }
                else{
                    right.getNode(object);
                }
            }
            return null;
        }

        public Pojo getValue() {
            return object;
        }

        public BinaryTreeNode addChild(BinaryTreeNode n) {
            int id = n.object.getInteger(idString);
            if(id < object.getInteger(idString)) {
                if (left != null) {
                    left.addChild(n);
                } else {
                    left = n;
                    parent = this;
                }
            }
            else if(id > object.getInteger(idString)) {
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

    public Pojo getObject() {
        return object;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public String toString() {
            return ""+object;
        }
    }

