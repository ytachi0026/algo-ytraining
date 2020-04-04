package dev.ytachi.hackerrank.interview.kit.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NewYearChaos {

    public static void main(String[] args) {

    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        final int t = q.length;

        int minimumBribes = 0;
        // i start from the end
        for (int i = t - 1; i >= 0; i--) {
            final int target = q[i];
            if (target - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, target - 2); j < i; j++) {
                if (q[j] > target) {
                    minimumBribes++;
                }
            }
        }

        System.out.println(minimumBribes);

    }

}
