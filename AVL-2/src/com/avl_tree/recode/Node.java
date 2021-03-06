package com.avl_tree.recode;

/**
 * For AVL tree , we will have lchild, rchild, data and height for balance factor calc
 */
public class Node {
    Node lChild;
    Node rChild;
    int data;
    int height;

    public Node(int data) {
        this.data = data;
    }
}
