package dev.ytachi.algorithms.tree;

public class Traversals {

    public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();
        tree.root = new NodeTree(1);
        tree.root.setLeft(new NodeTree(2));
        tree.root.setRight(new NodeTree(3));
        tree.root.getLeft().setLeft(new NodeTree(4));
        tree.root.getLeft().setRight(new NodeTree(5));

        System.out.println("Preorder traversal");
        tree.printPreorder(tree.root);
        System.out.println("/n");

        System.out.println("Inorder traversal");
        tree.printInorder(tree.root);
        System.out.println("/n");

        System.out.println("Postorder traversal");
        tree.printPostorder(tree.root);
        System.out.println("/n");
    }
}
