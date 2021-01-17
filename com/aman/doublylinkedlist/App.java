package com.aman.doublylinkedlist;

public class App {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.traverseList();
        System.out.println("Size of list - "+list.size());
        list.remove(3);
        list.traverseList();
        System.out.println("Size of list - "+list.size());
    }
}
