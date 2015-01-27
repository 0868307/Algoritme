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
    private class BinaryTreeNode {
        private Pojo object;
        private BinaryTreeNode parent,left,right;
        private String idString;


        public BinaryTreeNode(Pojo object, String idString) {
            this.object = object;
            this.idString = idString;
        }
        public BinaryTreeNode getNode(Pojo pojo)
        {
            return inOrderTraversal(pojo);
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
                    n.parent = this;
                }
            }
            else if(id > object.getInteger(idString)) {
                if (right != null) {
                    right.addChild(n);
                } else {
                    right = n;
                    n.parent = this;
                }
            }


            return n;
        }
        public void remove(){
            BinaryTreeNode lowest = this.right.getLastLeft();
            if(lowest == this)
            {
                lowest = this.right.getLastRight();
            }

            lowest.parent = parent;
            if(lowest != left)
            {
                lowest.left = left;
            }
            if(lowest != right){
                lowest.right = right;
            }
            if(parent != null)
            {
                if(parent.left != null){
                    if(parent.left.equals(this)){
                        parent.left = lowest;
                    }
                }
                else if(parent.right != null){
                    if(parent.right.equals(this)){
                        parent.right = lowest;
                    }
                }
            }

        }
        public BinaryTreeNode inOrderTraversal(Pojo pojo)
        {
            if(this.getValue() == pojo ){
                return this;
            }
            else{
                BinaryTreeNode node;
                if(left != null) {
                    node = right.inOrderTraversal(pojo);
                    if(node.getValue() == pojo)
                    {
                        return node;
                    }
                }
                if(right != null) {
                    node = right.inOrderTraversal(pojo);
                    if(node.getValue() == pojo)
                    {
                        return node;
                    }
                }
                return null;
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
        public BinaryTreeNode getLastRight(){
            if(this.left != null)
            {
                return this.right.getLastRight();
            }else
            {
                return this;
            }
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
}
