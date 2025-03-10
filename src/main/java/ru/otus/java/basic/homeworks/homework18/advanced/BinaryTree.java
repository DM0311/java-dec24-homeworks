package ru.otus.java.basic.homeworks.homework18.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> implements SearchTree<T> {

    TreeElement<T> root = null;
    List<T> sortedList;

    public BinaryTree(List<T> sortedList, boolean shuffling) {
        this.sortedList = sortedList;
        var arrCopy = new ArrayList<>(sortedList);
        if (shuffling){
            Collections.shuffle(arrCopy);
        }
        for(T item :arrCopy){
            var element = new TreeElement<>(item);
            insertItem(element);
        }
    }

    public BinaryTree(List<T> sortedList){
        this(sortedList,false);
    }


    @Override
    public T find(T element) {
        if(root==null){
            throw new RuntimeException("Binary Tree has no elements");
        }
        return recursionFind(root, element);
    }

    private T recursionFind(TreeElement<T> leaf, T findElement){
        if(leaf == null){
            return null;
        }
        var compared = leaf.getValue().compareTo(findElement);
        if (compared == 0){
            return leaf.getValue();
        } else if (compared > 0) {
            return recursionFind(leaf.getLeft(), findElement);
        }else{
            return recursionFind(leaf.getRight(), findElement);
        }
    }

    @Override
    public List<T> getSortedList() {
        return sortedList;
    }

    private void insertItem(TreeElement<T> item) {
        if (this.root == null) {
            this.root = item;
            return;
        }
        this.insertItem(this.root, item);
    }

    private void insertItem(TreeElement<T> rootItem, TreeElement<T> newItem) {
        if (newItem.getValue().compareTo(rootItem.getValue())<0) {
            if (rootItem.getLeft() == null) {
                rootItem.setLeft(newItem);
            } else {
                this.insertItem(rootItem.getLeft(), newItem);
            }
        }
        if (newItem.getValue().compareTo(rootItem.getValue())>0) {
            if (rootItem.getRight() ==  null) {
                rootItem.setRight(newItem);
            } else {
                this.insertItem(rootItem.getRight(), newItem);
            }
        }

    }
}
