package adt;

import pojos.Pojo;

/**
 * Created by darryl on 26-1-15.
 */
class BinaryTreeNode {
    private Pojo object;
    private BinaryTreeNode parent,left,right;
    private String idString;


    public BinaryTreeNode(Pojo object, String idString) {
        this.object = object;
        this.idString = idString;
    }
    public BinaryTreeNode getNode(Pojo pojo)
    {
        return inOrderTraversalR(pojo);
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
    public BinaryTreeNode inOrderTraversalR(Pojo pojo)
    {
        if(this.getValue() == pojo ){
            return this;
        }
        else{
            BinaryTreeNode node;
            if(left != null) {
                node = right.inOrderTraversalR(pojo);
                if(node.getValue() == pojo)
                {
                    return node;
                }
            }
            if(right != null) {
                node = right.inOrderTraversalR(pojo);
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
