package dev.ytachi.algorithms.tree;

public class NodeTree {
    private int data;
    private NodeTree left, right;

    NodeTree(final int item) {
        this.data = item;
        this.left = this.right = null;
        System.out.println();
    }

    public int getData() {
        return data;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(final NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(final NodeTree right) {
        this.right = right;
    }
}


