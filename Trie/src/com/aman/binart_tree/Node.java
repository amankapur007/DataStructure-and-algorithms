package com.aman.binart_tree;

/**
 * Author Aman
 * Date 15 02 2021
 * @param <T>
 */
public class Node<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node <T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node <T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node <T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node <T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
