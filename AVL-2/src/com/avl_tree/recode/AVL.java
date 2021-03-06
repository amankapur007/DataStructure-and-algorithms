package com.avl_tree.recode;

/**
 * Recoding the avl tree
 *
 */

//1. Insert same as binary search tree first
//2. Always set height as 1 for new node
//3. recalculate the height of node
//4. Check balance factor
public class AVL {

    Node root;

    public void insert(int data){
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        if(node == null) {
            node = new Node(data);
            node.height=1;
        }
        else if(data<node.data){
            node.lChild = insert(node.lChild, data);
        }else if(data>node.data){
            node.rChild = insert(node.rChild, data);
        }
        node.height = height(node);
        if(balanceFactor(node)==2 && balanceFactor(node.lChild)==1){
            //LLRotation
            return LLRotation(node);
        }else if(balanceFactor(node)==2 && balanceFactor(node.lChild)==-1){
            //LR Rotation
            return LRRotation(node);
        }else if(balanceFactor(node)==-2 && balanceFactor(node.rChild)==-1){
            //RR Rotation
        }else if(balanceFactor(node)==-2 && balanceFactor(node.rChild)==1){
            //RL Rotation
        }
        return node;
    }

    private Node LRRotation(Node parent) {
        Node parentLeftChild = parent.lChild;
        Node parentLeftChildRightChild = parentLeftChild.rChild;//right child of parent's left child

        parentLeftChild.rChild = parentLeftChildRightChild.lChild;
        parent.lChild = parentLeftChildRightChild.rChild;

        parentLeftChildRightChild.lChild = parentLeftChild;
        parentLeftChildRightChild.rChild = parent;

        parentLeftChild.height = height(parentLeftChild);
        parent.height = height(parent);
        parentLeftChildRightChild.height = height(parentLeftChildRightChild);
        if(root == parent){
            root=parentLeftChildRightChild;
        }

        return parentLeftChildRightChild;
    }


    private Node RLRotation(Node parent) {
        Node parentRightChild = parent.rChild;
        Node parentRightChildLeftChild = parentRightChild.lChild;//right child of parent's left child

        parentRightChild.lChild = parentRightChildLeftChild.rChild;
        parent.rChild = parentRightChildLeftChild.lChild;

        parentRightChildLeftChild.rChild = parentRightChild;
        parentRightChildLeftChild.lChild = parent;

        parentRightChild.height = height(parentRightChild);
        parent.height = height(parent);
        parentRightChildLeftChild.height = height(parentRightChildLeftChild);
        if(root == parent){
            root=parentRightChildLeftChild;
        }

        return parentRightChildLeftChild;
    }

    private Node LLRotation(Node parent) {
        Node parentLeftChild = parent.lChild;//left child of parent
        Node parentLeftChildRightChild = parentLeftChild.rChild;//right child of parent's left child

        parentLeftChild.rChild = parent;
        parent.lChild = parentLeftChildRightChild;

        parent.height = height(parent);
        parentLeftChild.height = height(parentLeftChild);
        return parentLeftChild;
    }

    private Node RRRotation(Node parent) {
        Node parentRightChild = parent.rChild;//right child of parent
        Node parentRightChildLeftChild = parentRightChild.lChild;//left child of parent's right child

        parentRightChild.lChild = parent;
        parent.rChild = parentRightChildLeftChild;

        parent.height = height(parent);
        parentRightChild.height = height(parentRightChild);
        return parentRightChild;
    }

    private int balanceFactor(Node node) {
        int leftHeight = node!=null && node.lChild!=null?node.lChild.height:0;
        int rightHeight = node!=null && node.rChild!=null?node.rChild.height:0;
        return leftHeight-rightHeight;
    }

    private int height(Node node) {
        int leftHeight = node!=null && node.lChild!=null?node.lChild.height:0;
        int rightHeight = node!=null && node.rChild!=null?node.rChild.height:0;
        return Math.max(leftHeight, rightHeight)+1;
    }
}
