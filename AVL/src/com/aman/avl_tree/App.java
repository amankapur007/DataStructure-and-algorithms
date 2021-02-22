package com.aman.avl_tree;

public class App {
    public static void main(String[] args) {
        AVL tree =  new AVL();
        tree.insert(20);
        tree.insert(25);
        tree.insert(30);
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(27);
        tree.insert(19);
        tree.insert(16);
        tree.display();
    }
}
