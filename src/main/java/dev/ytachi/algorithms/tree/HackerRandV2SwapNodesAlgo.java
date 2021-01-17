package dev.ytachi.algorithms.tree;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class HackerRandV2SwapNodesAlgo {

    public static class NodeTree {
        int data;
        NodeTree left, right;

        NodeTree(final int item) {
            this.data = item;
            this.left = this.right = null;
        }
    }

    public static void printInorder(NodeTree node, List<Integer> result) {
        if (node == null)
            return;

        /* first recur on left sutree */
        printInorder(node.left, result);

        /* then print data of node */
        System.out.print(node.data +" ");
        result.add(node.data);

        /* now recur on right subtree */
        printInorder(node.right, result);
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        int N = indexes.length;

        NodeTree[] nodes = new NodeTree[N + 1];
        int test[][] = new int[queries.length][indexes.length];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new NodeTree(i); // We set the data of each node, starting by 1
        }

        for (int i = 1; i <= N; i++) {
            int left = indexes[i - 1][0];
            int right = indexes[i - 1][1];
            nodes[i].left = left == -1 ? null : nodes[left];
            nodes[i].right = right == -1 ? null : nodes[right];
        }

        for (int j=0; j<queries.length; j++ ) {
            int K = queries[j];
            swap(K, nodes[1], 1);
            List<Integer> result = new ArrayList<>();
            printInorder(nodes[1], result);
            System.out.println();
            for (Integer temp : result){
                System.out.print(temp + " ");
            }
            System.out.println();
            test[j] = result.stream().mapToInt(i -> i).toArray();

        }

        return test;
    }

    static void swap(final int K, final NodeTree node, int depth) {
        if (node == null) {
            return;
        }

        swap(K, node.left, depth + 1);
        swap(K, node.right, depth + 1);

        if (depth % K == 0) {
            NodeTree temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
