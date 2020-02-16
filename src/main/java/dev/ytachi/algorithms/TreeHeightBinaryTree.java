package dev.ytachi.algorithms;

public class TreeHeightBinaryTree {
    public static void main(String[] args) {

        final BinaryTree tree = new BinaryTree();
        tree.root = new NodeTree(1);
        tree.root.setLeft(new NodeTree(2));
        tree.root.setRight(new NodeTree(3));
        tree.root.getLeft().setLeft(new NodeTree(4));
        tree.root.getLeft().setRight(new NodeTree(5));

        final int treeHeight = tree.maxDepth(tree.root);
        System.out.println(String.format("The height of the binary tree is: %d", treeHeight ));
    }
}

// guys we need a tree

class NodeTree {
    private int data;
    private NodeTree left, right;

    NodeTree(final int item) {
        this.data = item;
        this.left = this.right = null;
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

class BinaryTree {
    NodeTree root; // We all know that a tree, always have a root leaf

    public int maxDepth(final NodeTree node) { // we will use recursion, as I read many solutions and they agree on this
        if (node == null) {
            return 0;// because there is no depth on null
        } else {
            int leftDepth = maxDepth(node.getLeft());
            int rightDepth = maxDepth(node.getRight());

            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }

        }
    }
}
