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
    public void removeNode(Pojo object)
    {
        if(object == head.getValue()){

            head.remove();
            if(head.getLeft() != null){
                head = head.getLeft();
            }else if(head.getRight() != null){
                head = head.getRight();
            }else{
                head = null;
            }
        }else{
            BinaryTreeNode node = head.getNode(object);
            if(node != null)
            {
                node.remove();
            }else{
                System.out.println("node is not found");
            }
        }
    }
    public void print(){
        printNodes(head);
    }
    public void printNodes(BinaryTreeNode currentNode){
        if(currentNode != null)
        {
            System.out.println("---------------");
            if(currentNode.getParent() != null){
                System.out.println("Parent : "+currentNode.getParent());
            }
            System.out.println("This : "+currentNode);
            if(currentNode.getLeft() != null){
                System.out.println("Left : " + currentNode.getLeft());
                printNodes(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                System.out.println("Right : " + currentNode.getRight());
                printNodes(currentNode.getRight());
            }
        }
    }


}