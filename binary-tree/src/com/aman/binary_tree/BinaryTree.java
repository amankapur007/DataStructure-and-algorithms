package com.aman.binary_tree;

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


}
