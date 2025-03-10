package ru.otus.java.basic.homeworks.homework18.advanced;

import java.util.List;

public class BinaryTree<T extends Comparable> implements SearchTree {

    TreeElement root = null;
    List<T> sortedList;

    public BinaryTree(List<T> sortedList) {
        this.sortedList = sortedList;
        for(T item :sortedList){
            TreeElement element = new TreeElement<>(item);
            insertItem(element);
        }
    }


    @Override
    public Object find(Integer element) {
        TreeElement searchedElement = new TreeElement<>(element);
        if(root==null){
            throw new RuntimeException("Binary Tree has no elements");
        }
        if (root.getValue()==element){
            return root.getValue();
        } else if (element>root.getValue()) {

        }
        return root.getValue();
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
        if (newItem.getValue().compareTo(rootItem.getValue())<0) {
            if (rootItem.getLeft() == null) {
                rootItem.setLeft(newItem);
            } else {
                this.insertItem(rootItem.getLeft(), newItem);
            }
        }
        if (newItem.getValue().compareTo(rootItem.getValue())>0) {
            if (rootItem.getRight() ==  null) {
                rootItem.setRight(newItem);;
            } else {
                this.insertItem(rootItem.getRight(), newItem);
            }
        }

    }
}
