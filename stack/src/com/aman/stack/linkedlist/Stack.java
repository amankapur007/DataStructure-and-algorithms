package com.aman.stack.linkedlist;

/**
 * Singly Node class
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data= data;
    }
}

public class Stack {
    Node head;
    int size=0;
    Stack(){

    }

    public int pop(){
        if(head==null) throw new IllegalStateException();
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int peek(){
        if(head==null) throw new IllegalStateException();
        return head.data;
    }

    public void push(int data){
        if(head==null){
            head =  new Node(data);
        }

        Node newNode =  new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
}
