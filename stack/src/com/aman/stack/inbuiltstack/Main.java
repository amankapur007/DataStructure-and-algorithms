package com.aman.stack.inbuiltstack;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> myStack =  new ArrayDeque <>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("Pop: "+myStack.pop());
        myStack.push(4);
        myStack.push(5);
        System.out.println("Peek: "+myStack.peek());
        myStack.push(6);
        System.out.println("Size: "+myStack.size());
        myStack.push(10);
    }
}
