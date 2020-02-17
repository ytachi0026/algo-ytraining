package dev.ytachi.algorithms.tree;

import java.util.Scanner;

public class HackerRankSwapNodes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        // Here we have an array of Nodes.
        NodeTree[] nodes = new NodeTree[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new NodeTree(i); // We set the data of each node, starting by 1
        }

        final BinaryTree tree = new BinaryTree();
        tree.root = nodes[1];

        for (int i = 1; i <= N; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            nodes[i].setLeft(left == -1 ? null : nodes[left]);
            nodes[i].setRight(right == -1 ? null : nodes[right]);
        }

        // Number of swaps
        final int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int K = in.nextInt();
            swap(K, nodes[1], 1);
            tree.printInorder(tree.root);
            System.out.println();
        }

        in.close();
    }

    static void swap(final int K, final NodeTree node, int depth) {
        if (node == null) {
            return;
        }

        swap(K, node.getLeft(), depth + 1);
        swap(K, node.getRight(), depth + 1);

        if (depth % K == 0) {
            NodeTree temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
    }
}
