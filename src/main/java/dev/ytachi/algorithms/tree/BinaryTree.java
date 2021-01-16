package dev.ytachi.algorithms.tree;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    NodeTree root; // We all know that a tree, always have a root leaf

    public int maxDepthNodeApproach(final NodeTree node) { // we will use recursion, as I read many solutions and they agree on this
        if (node == null) {
            return 0;// because there is no depth on null
        } else {
            int leftDepth = maxDepthNodeApproach(node.getLeft());
            int rightDepth = maxDepthNodeApproach(node.getRight());

            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }

        }
    }

    public int maxDepthEdgeApproach(final NodeTree node) { // we will use recursion, as I read many solutions and they agree on this
        if (node == null) {
            return -1;// because there is no depth on null, we return -1, because we are not counting NODES
        } else {
            int leftDepth = maxDepthEdgeApproach(node.getLeft());
            int rightDepth = maxDepthEdgeApproach(node.getRight());

            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }

        }
    }

    // similar to graph, BREADTH
    public void levelOrderTraversal(final NodeTree nodeTree) {
        // We are gonna use the logic for the graph, depth search, since we are on a tree, we don't have re visiting

        Queue<NodeTree> queue = new LinkedList<>();
        queue.add(nodeTree);

        NodeTree current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            System.out.println(String.format("Node %s", current.getData() + ""));

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }

        }
    }

    // using Tree Traversals (Inorder, Preorder and Postorder)

    /**
     *
     * Algorithm Preorder(tree)
     *    1. Visit the root.
     *    2. Traverse the left subtree, i.e., call Preorder(left-subtree)
     *    3. Traverse the right subtree, i.e., call Preorder(right-subtree)
     * @param node
     */
    public void printPreorder(NodeTree node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.getData() + " ");

        /* then recur on left sutree */
        printPreorder(node.getLeft());

        /* now recur on right subtree */
        printPreorder(node.getRight());
    }

    /**
     *
     Algorithm Inorder(tree)
     1. Traverse the left subtree, i.e., call Inorder(left-subtree)
     2. Visit the root.
     3. Traverse the right subtree, i.e., call Inorder(right-subtree)
     * @param node
     */
    public void printInorder(NodeTree node) {
        if (node == null)
            return;

        /* first recur on left sutree */
        printInorder(node.getLeft());

        /* then print data of node */
        System.out.print(node.getData() + " ");

        /* now recur on right subtree */
        printInorder(node.getRight());
    }

    /**
     *
     Algorithm Postorder(tree)
     1. Traverse the left subtree, i.e., call Postorder(left-subtree)
     2. Traverse the right subtree, i.e., call Postorder(right-subtree)
     3. Visit the root.
     * @param node
     */
    public void printPostorder(NodeTree node) {
        if (node == null)
            return;

        /* first recur on left sutree */
        printPostorder(node.getLeft());


        /* then recur on right subtree */
        printPostorder(node.getRight());

        /* now print data of node */
        System.out.print(node.getData() + " ");
    }
}
