package dev.ytachi.hackerrank.interview.kit.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * https://www.youtube.com/watch?v=hDhf04AJIRs
 *
 *    👉 Need of prefix-sum Algorithm | EP1: https://youtu.be/scD312I7kkE
 *    👉 Prefix Sum Algorithm | Difference Array | EP2 : https://youtu.be/pVS3yhlzrlQ
 *    👉 Time Limit Exceeded- How To Overcome TLE ? : https://youtu.be/S8V444xdNvM
 */
public class ArrayManipulation {

    public static void main(String[] args) {

    }

    static long arrayManipulationBetterApproach(int n, int[][] queries) {

        long[] mapping = new long[n+1];
        int a, b, k;
        for (int i = 0; i < queries.length; i++) {
            a = queries[i][0];
            b = queries[i][1];
            k = queries[i][2];
            mapping[a] += k;
            if (b + 1 < n+1) {
                mapping[b + 1] -= k;
            }
        }

        long max = Long.MIN_VALUE;
        long current = mapping[0];
        for (int j = 1; j < n+1; j++) {
            mapping[j] = current + mapping[j];
            current = mapping[j];
            if (mapping[j] > max) {
                max = mapping[j];
            }
        }

        return max;
    }



    // Complete the arrayManipulation function below.
    // this solution: Your code did not execute within the time limits
    static long arrayManipulation(int n, int[][] queries) {
        // i am gonna handle this problem with hashmap

        // Setting up this map.
        Map<Integer, Long> mapping = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            mapping.put(i, 0l);
        }

        int a, b, k;
        for (int i = 0; i < queries.length; i++) {
            a = queries[i][0];
            b = queries[i][1];
            k = queries[i][2];
            for (int j = a; j <= b; j++) {
                mapping.put(j, mapping.get(j) + k);
            }
        }

        Optional<Entry<Integer, Long>> maxEntry = mapping.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        return maxEntry.get().getValue();

    }


}
