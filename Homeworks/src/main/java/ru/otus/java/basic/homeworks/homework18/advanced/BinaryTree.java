package ru.otus.java.basic.homeworks.homework18.advanced;

import java.util.List;

public class BinaryTree<T extends Comparable> implements SearchTree<T> {

    private TreeElement<T> root = null;
    private List<T> sortedList;

    public BinaryTree(List<T> sortedList) {
        this.sortedList = sortedList;
        for (T item : sortedList) {
            TreeElement element = new TreeElement<>(item);
            insertItem(element);
        }
    }

    @Override
    public T find(T element) {
        TreeElement<T> searchedElement = new TreeElement<>(element);
        if (root == null) {
            throw new RuntimeException("Binary Tree has no elements");
        }
        if (root.getValue() == searchedElement.getValue()) {
            return root.getValue();
        } else if (searchedElement.getValue().compareTo(root.getValue()) < 0) {
            return find(root.getLeft(), searchedElement).getValue();
        } else {
            return find(root.getRight(), searchedElement).getValue();
        }
    }

    private TreeElement<T> find(TreeElement<T> root, TreeElement <T>element) {
        if(root.getValue() == element.getValue()){
            return root;
        }
        if (element.getValue().compareTo(root.getValue()) < 0) {
            return this.find(root.getLeft(), element);
        } else {
            return this.find(root.getRight(), element);
        }
    }


    @Override
    public List<T> getSortedList() {
        return sortedList;
    }


    private void insertItem(TreeElement item) {
        if (this.root == null) {
            this.root = item;
            return;
        }
        this.insertItem(this.root, item);
    }

    private void insertItem(TreeElement rootItem, TreeElement newItem) {
        if (newItem.getValue().compareTo(rootItem.getValue()) < 0) {
            if (rootItem.getLeft() == null) {
                rootItem.setLeft(newItem);
            } else {
                this.insertItem(rootItem.getLeft(), newItem);
            }
        }
        if (newItem.getValue().compareTo(rootItem.getValue()) > 0) {
            if (rootItem.getRight() == null) {
                rootItem.setRight(newItem);
            } else {
                this.insertItem(rootItem.getRight(), newItem);
            }
        }

    }
}
