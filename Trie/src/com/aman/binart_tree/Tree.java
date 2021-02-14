package com.aman.binart_tree;

public interface Tree<T> {
    void traversal();
    void insert(T data);
    void delete(T data);
    T getMax();
    T getMin();
}
