package com.aman.binart_tree;

public class BinaryTree<T extends Comparable<T>> implements Tree<T>{

    public Node<T> root;

    @Override
    public void insert(T data) {
        if(this.root==null){
            this.root = new Node<>(data);
        }else{
            insertNode(data, root);
        }
    }

    private void insertNode(T data, Node<T> node) {
        if(data.compareTo(node.getData())<0){
            if(node.getLeftChild()!=null){
                insertNode(data, node.getLeftChild());
            }else{
                node.setLeftChild(new Node <>(data));
            }
        }else {
            if(node.getRightChild()!=null){
                insertNode(data, node.getRightChild());
            }else{
                node.setRightChild(new Node <>(data));
            }
        }
    }

    @Override
    public void traversal() {
        if(this.root == null){
            System.out.print("null");
        }else{
            inOrder(this.root);
        }
    }

    private void inOrder(Node<T> node) {
        if(node.getLeftChild()!=null)
            inOrder(node.getLeftChild());
        System.out.print(node.getData()+" ");
        if(node.getRightChild()!=null)
            inOrder(node.getRightChild());
    }

    @Override
    public void delete(T data) {
            if(this.root==null){
                System.out.println("no data");
            }else{
               delete(data, root);
            }

    }

    private Node<T> delete(T data, Node<T> node) {
        if(data.compareTo(node.getData())<0){
            node.setLeftChild(delete(data, node.getLeftChild()));
        }else if(data.compareTo(node.getData())>0){
            node.setRightChild(delete(data, node.getRightChild()));
        }else{
            if(node.getLeftChild() == null && node.getRightChild()==null){
                return null;
            }else if(node.getLeftChild() == null){
                return node.getRightChild();
            }else if(node.getRightChild() == null){
                return node.getLeftChild();
            }
                Node<T> tempNode = getPredecessor(node.getLeftChild());
                node.setData(tempNode.getData());
                node.setLeftChild(delete(tempNode.getData(), node.getLeftChild()));
        }
        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild()!=null){
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public T getMax() {
        if(this.root == null){
            return null;
        }else{
            return getMax(this.root);
        }
    }

    private T getMax(Node<T> node) {
        if(node.getRightChild()!=null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if(this.root == null){
            return null;
        }else{
            return getMin(this.root);
        }
    }

    private T getMin(Node<T> node) {
        if(node.getLeftChild()!=null){
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }
}
