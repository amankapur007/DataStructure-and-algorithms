package com.aman.stack.array;

public class Main {
    public static void main(String[] args) {
        Stack myStack =  new Stack(5);
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
