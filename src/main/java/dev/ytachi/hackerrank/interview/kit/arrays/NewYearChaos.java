package dev.ytachi.hackerrank.interview.kit.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NewYearChaos {

    public static void main(String[] args) {

    }

    static void minimumBribesAlternative(int[] q) {
        int bribes = 0;
        int temporal;
        for (int index = q.length - 1; index >= 0; index++) {
            int position = index + 1;
            if (q[index] != position) {
                if ((index - 1 >= 0) && (q[index - 1] == position)) {
                    temporal = q[index - 1];
                    q[index - 1] = q[index];
                    q[index] = temporal;
                    bribes++;
                } else if (index - 2 >= 0 && q[index - 2] == position) {
                    temporal = q[index - 2];
                    q[index - 2] = q[index - 1];
                    q[index - 1] = q[index];
                    q[index] = temporal;
                    bribes += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }

            } else {
                // nothing happens
            }

        }
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
