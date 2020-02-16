package dev.ytachi.algorithms.tree;

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
