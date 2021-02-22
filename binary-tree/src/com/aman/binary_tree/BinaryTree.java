package com.aman.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Node
 */
class Node{
    int data;
    Node lChild;
    Node rChild;

    Node(int data){
        this.data = data;
    }
}

/**
 * BST
 */
public class BinaryTree {
    Node root;

    public  void insert(int data){
        this.root = insert(this.root, data);
    }

    /**
     * Inserting the data
     * @param node-
     * @param data-
     * @return -
     */
    private Node insert(Node node, int data) {
        if(node == null){
            node = new Node(data);
        }
        else if(data< node.data){
            node.lChild = insert(node.lChild, data);
        }else if(data> node.data){
            node.rChild = insert(node.rChild, data);
        }
        return  node;
    }

    public  void delete(int data){
        this.root = delete(this.root, data);
    }

    private Node delete(Node node, int data) {
        if(node == null){
            return  null;
        }

        if(node.lChild == null && node.rChild == null){
            return null;
        }

        if(data<node.data){
            node.lChild = delete(node.lChild, data);
        }else if(data> node.data){
            node.rChild = delete(node.rChild, data);
        }else{
            if(height(node.lChild)>height(node.rChild)){
                Node temp  = inOrderPredecessor(node.lChild);
                node.data = temp.data;
                node.lChild = delete(node.lChild, data);
            }else{
                Node temp  = inOrderSuccessor(node.rChild);
                node.data = temp.data;
                node.rChild = delete(node.rChild, data);
            }
        }
        return node;
    }

    private Node inOrderSuccessor(Node node) {
        while (node!=null && node.lChild!=null){
            node = node.lChild;
        }
        return node;
    }

    private Node inOrderPredecessor(Node node) {
        while (node!=null && node.rChild!=null){
            node = node.rChild;
        }
        return node;
    }

    /**
     * Height
     * @param node-
     * @return -
     */
    private int height(Node node) {
        if(node==null)return 0;
        int x = height(node.lChild);
        int y = height(node.rChild);
        return x>y?x+1:y+1;

    }

    public void display(){
        display(this.root);
    }

    private void display(Node node) {
        if (node == null){
            return;
        }
        String str = "";

        if(node.lChild == null){
            str+=".";
        }else{
            str+=node.lChild.data;
        }

        str+="=>"+node.data+"<=";

        if(node.rChild == null){
            str+=".";
        }else{
            str+=node.rChild.data;
        }

        System.out.println(str);
        display(node.lChild);
        display(node.rChild);
    }

    public void inOrder(){
        System.out.println("In Order");
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if(node == null)return;
        inOrder(node.lChild);
        System.out.print(node.data+" ");
        inOrder(node.rChild);
    }

    public void preOrder(){
        System.out.println("Pre Order");
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if(node == null)return;
        System.out.print(node.data+" ");
        preOrder(node.lChild);
        preOrder(node.rChild);
    }

    public void postOrder(){
        System.out.println("Post Order");
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if(node == null)return;
        postOrder(node.lChild);
        postOrder(node.rChild);
        System.out.print(node.data+" ");
    }

    public  void levelOrder(){
        System.out.println("Level Order");
        Queue <Node> queue = new LinkedList <>();
        if(this.root!=null){queue.add(this.root);}
        levelOrder(queue);
        System.out.println();
    }

    private void levelOrder(Queue<Node> queue) {
        if (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.data+" ");
            if(temp.lChild!=null){queue.add(temp.lChild);}
            if(temp.rChild!=null){queue.add(temp.rChild);}
            levelOrder(queue);
        }
    }

    public int height(){
        return height(this.root);
    }
}