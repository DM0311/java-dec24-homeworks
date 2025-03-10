package ru.otus.java.basic.homeworks.homework18.advanced;

public class TreeElement<T extends Comparable<T>> {
    private T value;
    private TreeElement left;
    private TreeElement right;
    private TreeElement parent;


    public TreeElement(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeElement getLeft() {
        return left;
    }

    public void setLeft(TreeElement left) {
        this.left = left;
    }

    public TreeElement getRight() {
        return right;
    }

    public void setRight(TreeElement right) {
        this.right = right;
    }

    public TreeElement getParent() {
        return parent;
    }

    public void setParent(TreeElement parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }
}
