package com.aman.binary_tree;

public class App {
    public static void main(String[] args) {
        BinaryTree bst =  new BinaryTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.inOrder();
        bst.preOrder();
        bst.postOrder();
        bst.levelOrder();
        System.out.println("----------");
        bst.display();
        System.out.println("----------");
        bst.delete(20);
        bst.display();
        System.out.println("----------");
        bst.delete(30);
        bst.display();
        System.out.println("----------");
        bst.delete(50);
        bst.display();
        System.out.println("Height");
        System.out.println(bst.height());
    }
}
