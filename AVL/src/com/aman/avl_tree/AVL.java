package com.aman.avl_tree;

class Node{
    int data;
    Node lChild;
    Node rChild;
    int heigth;

    public Node(int data) {
        this.data = data;
    }
}
public class AVL {
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

        node.heigth = height(node);

        int bf = balanceFactor(node);

        //LL
        if(bf>1 && data<node.lChild.data){
            return rightRotation(node);
        }
        //RR
        else if(bf<-1 && data>node.rChild.data){
            return leftRotation(node);
        }
        //LR
        else if(bf>1 && data>node.lChild.data){
            node.lChild = leftRotation(node.lChild);
            return rightRotation(node);
        }
        //RL
        else if(bf<-1 && data<node.rChild.data){
            node.rChild = rightRotation(node.rChild);
            return leftRotation(node);
        }
        return  node;
    }

    private Node leftRotation(Node a) {
        Node b = a.rChild;
        Node d = b.lChild;

        b.lChild = a;
        a.rChild = d;

        a.heigth = height(a);
        b.heigth = height(b);
        return b;
    }

    private Node rightRotation(Node a) {
        Node b = a.lChild;
        Node d = b.rChild;

        b.rChild = a;
        a.lChild = d;

        a.heigth = height(a);
        b.heigth = height(b);
        return b;
    }

    private int balanceFactor(Node node) {
        int lh = node!=null && node.lChild!=null?node.lChild.heigth:0;
        int rh = node!=null && node.rChild!=null?node.rChild.heigth:0;
        return lh-rh;
    }

    private int height(Node node) {
        int x = node!=null && node.lChild!=null?node.lChild.heigth:0;
        int  y = node!=null && node.rChild!=null?node.rChild.heigth:0;
        return x>y?x+1:y+1;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        if (node.lChild == null) {
            str += ".";
        } else {
            str += node.lChild.data;
        }

        str += "=>" + node.data + "<=";

        if (node.rChild == null) {
            str += ".";
        } else {
            str += node.rChild.data;
        }

        System.out.println(str);
        display(node.lChild);
        display(node.rChild);
    }

}
