package dev.ytachi.algorithms.tree;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
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
}
