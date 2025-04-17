package ru.otus.java.basic.homeworks.homework18.advanced;

public class TreeElement<C extends Comparable> {
    private C value;
    private TreeElement<C> left;
    private TreeElement<C> right;
    private TreeElement<C> parent;


    public TreeElement(C value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public C getValue() {
        return value;
    }

    public void setValue(C value) {
        this.value = value;
    }

    public TreeElement<C> getLeft() {
        return left;
    }

    public void setLeft(TreeElement<C> left) {
        this.left = left;
    }

    public TreeElement<C> getRight() {
        return right;
    }

    public void setRight(TreeElement<C> right) {
        this.right = right;
    }

    public TreeElement<C> getParent() {
        return parent;
    }

    public void setParent(TreeElement<C> parent) {
        this.parent = parent;
    }
}
