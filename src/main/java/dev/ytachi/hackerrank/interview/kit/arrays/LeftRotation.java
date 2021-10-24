package dev.ytachi.hackerrank.interview.kit.arrays;

import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays&h_r=next-challenge&h_v=zen
 */
public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        final int n = a.length;

        if (d == n) {
            return a;
        }

        int[] result = new int[n];
        int index = 0;

        for (int i = d; i < n; i ++){
            result[index] = a[i];
            index++;
        }

        for (int i = 0; i < d; i++) {
            result[index] = a[i];
            index++;
        }

        return result;
    }

    static int[] rotationToLeft(final int[] target, final int d) {
        int[] result = new int[target.length];
        System.out.println(result);
        int indexT;
        int indexR = 0;

        for (indexT = d; indexT < target.length; indexT++) {
            result[indexR] = target[indexT];
            indexR++;
        }

        for (indexT = 0; indexT < d; indexT++) {
            result[indexR] = target[indexT];
            indexR++;
        }

        return result;
    }

}
