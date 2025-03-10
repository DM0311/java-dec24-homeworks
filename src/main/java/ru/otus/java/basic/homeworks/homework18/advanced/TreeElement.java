package ru.otus.java.basic.homeworks.homework18.advanced;

public class TreeElement<T extends Comparable<T>> {
    private final T value;
    private TreeElement<T> left;
    private TreeElement<T> right;
    private TreeElement<T> parent;


    public TreeElement(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeElement<T> getLeft() {
        return left;
    }

    public void setLeft(TreeElement<T> left) {
        this.left = left;
    }

    public TreeElement<T> getRight() {
        return right;
    }

    public void setRight(TreeElement<T> right) {
        this.right = right;
    }

    public TreeElement<T> getParent() {
        return parent;
    }

    public void setParent(TreeElement<T> parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }
}
