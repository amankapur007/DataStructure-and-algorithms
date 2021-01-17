package com.aman.stack.linkedlist;

/**
 * This can be more efficient using doubly linked list
 * in that case pop will be very easy without loop as we will hvae prev 
 * tail is used for bit performence impovement so that for push no need of loop as we hve next
 */
public class Stack {
    
    private Node root;
    private Node tail;
    private int size;

    public void push(int data){

        ++this.size;
        if(this.root == null){
            this.root = new Node(data);
            this.tail = this.root;
        }else{
            this.tail.setNextNode(new Node(data));
            this.tail = this.tail.getNextNode();
        }
    }

    public int peek(){
        if(this.tail==null){
            return -1;
        }
        return this.tail.getData();
    }

    public int pop(){
        if(this.root == null){
            return -1;
        }
        --this.size;
        Node temp = this.root;
        Node prev = null;
        int data = -1;
        while(temp.getNextNode()!=null){
            prev = temp;
            temp = temp.getNextNode();
        }
        if(prev!=null){
            prev.setNextNode(null);
        }else{
            prev=null;
            root=null;
        }
        tail= prev;
        data = temp.getData();
        temp = null;
        return data;
    }

    public int size(){
        return this.size;
    }

}
