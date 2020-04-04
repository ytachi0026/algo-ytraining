package dev.ytachi.hackerrank.interview.kit.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2 {

    public static void main(String[] args) {

    }

    // not efficiente brute force method
    static int bruteForceSwaps(final int[] arr) {

        return 0;
    }

    // version 2 is more efficiente, since i don't need to create a hashmap, i use the aforementioned array
    static int minimumSwaps2(final int[] arr) {
        boolean[] isVisited = new boolean[arr.length];
        int minimumSwaps = 0;

        for (int k = 0; k < isVisited.length; k++) {
            int nextValue;

            if (!isVisited[k]) {
                isVisited[k] = true;
                int position = k + 1;
                if (position == arr[k]) {
                    continue;
                }

                int nextValueIndex = arr[k] - 1;
                while (!isVisited[nextValueIndex]) {
                    isVisited[nextValueIndex] = true;
                    nextValue = arr[nextValueIndex];
                    nextValueIndex = nextValue - 1;
                    minimumSwaps++;
                }
            }
        }
        return minimumSwaps;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(final int[] arr) {

        boolean[] isVisited = new boolean[arr.length + 1];
        Map<Integer, Integer> nodeMap = new HashMap<>();

        for (int i = 1; i < isVisited.length; i++) {
            nodeMap.put(i, arr[i - 1]);
        }


        int minimumSwaps = 0;

        for (int k = 1; k <= nodeMap.size(); k++) {
            int nextNode;

            if (!isVisited[k]) {
                isVisited[k] = true;

                if (k == nodeMap.get(k)) {
                    continue;
                }

                int nextValueIndex = nodeMap.get(k);

                while (!isVisited[nextValueIndex]) {
                    isVisited[nextValueIndex] = true;
                    nextNode = nodeMap.get(nextValueIndex);
                    nextValueIndex = nextNode;
                    minimumSwaps++;
                }
            }
        }


        return minimumSwaps;
    }


}
