package com.aman.doublylinkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++this.sizeOfList;
        if(this.root == null){
            this.root =  new Node<T>(data);
        }else{
            insertAtBeginning(data);
        }
    }

    public void insertAtBeginning(T data) {
        Node<T> newNode =  new Node<T>(data);
        this.root.setPrevNode(newNode);
        newNode.setNextNode(this.root);
        this.root =  newNode;
    }

    public void insertDataAtEnd(T data){
        Node<T> temp =  this.root;
        while(temp.getNextNode()!=null){
            temp = temp.getNextNode();
        }
        Node<T> newNode =  new Node<T>(data);
        newNode.setPrevNode(temp);
        temp.setNextNode(newNode);
    }

    @Override
    public void remove(T data) {
        if(this.root == null){
            return;
        }
        --this.sizeOfList;
        remove(data,this.root, this.root.getNextNode());
        
    }

    public void remove(T data, Node<T> prevNode, Node<T> actualNode){
        while(actualNode!=null){
            if(actualNode.getData().compareTo(data) == 0){
                prevNode.setNextNode(actualNode.getNextNode());
                if(actualNode.getNextNode()!=null){
                    actualNode.getNextNode().setPrevNode(prevNode);
                }
                return;
            }else{
                prevNode = actualNode;
                actualNode = actualNode.getNextNode();
            }
        }
    }

    @Override
    public void traverseList() {
        Node<T> temp =  this.root;
        while(temp!=null){
            System.out.print(temp + " , ");
            temp = temp.getNextNode();
        }
        System.out.println();
    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
    
}
