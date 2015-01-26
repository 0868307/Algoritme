package adt;

import pojos.Pojo;

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