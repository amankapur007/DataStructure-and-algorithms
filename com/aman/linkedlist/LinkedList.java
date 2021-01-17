package com.aman.linkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++this.sizeOfList;
        if(null==root){
            this.root= new Node<T>(data);
        }else{
            insertAtBeginning(data);
        }
    }

    // O(1)
    public void insertAtBeginning(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.setNextNode(root);
        this.root = newNode;
        
    }

    // O(N)
    public void insertDataAtEnd(T data, Node<T> node){
        if(node.getNextNode() != null){
            insertDataAtEnd(data, node.getNextNode());
        }else{
            Node<T> newNode = new Node<T>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if(this.root==null){
            return;
        }
        --this.sizeOfList;
        if(this.root.getData().compareTo(data) == 0 ){
            this.root = this.root.getNextNode();
        }else{
            remove(data, root, root.getNextNode());
        }
    }

    public void remove(T data, Node<T> prevNode, Node<T> actualNode){
        while(actualNode!=null){
            if(actualNode.getData().compareTo(data) == 0){
                prevNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }else{
                prevNode = actualNode;
                actualNode = actualNode.getNextNode();
            }
        }
    }

    @Override
    public void traverseList() {
        if(this.root == null){
            return;
        }

        Node<T> actualNode = this.root;
        while(actualNode!=null){
            System.out.print(actualNode+" -> ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println("null");
    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
    
}
