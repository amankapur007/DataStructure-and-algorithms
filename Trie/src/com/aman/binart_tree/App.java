package com.aman.binart_tree;

public class App {
    public static void main(String[] args) {
        Tree<String> family =  new BinaryTree <>();
        family.insert("A");
        family.insert("B");
        family.insert("C");
        family.insert("D");
        family.insert("E");
        family.insert("F");
        family.traversal();
        Tree<Integer> bst =  new BinaryTree <>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        System.out.println("bst.getMin() = " + bst.getMin());
        System.out.println("bst.getMax() = " + bst.getMax());
        bst.traversal();
        System.out.println();
        bst.delete(10);
        bst.traversal();
    }
}
