package dev.ytachi.algorithms.tree;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        final BinaryTree tree_level = new BinaryTree();
        tree_level.root = new NodeTree(1);
        tree_level.root.setLeft(new NodeTree(2));
        tree_level.root.setRight(new NodeTree(3));
        tree_level.root.getLeft().setLeft(new NodeTree(4));
        tree_level.root.getLeft().setRight(new NodeTree(5));

        tree_level.levelOrderTraversal(tree_level.root);
    }
}
