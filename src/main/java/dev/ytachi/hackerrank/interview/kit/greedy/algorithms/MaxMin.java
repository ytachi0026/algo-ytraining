package dev.ytachi.hackerrank.interview.kit.greedy.algorithms;

import java.util.Arrays;

/**
 * URL: https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class MaxMin {

    public static void main(String[] args) {
        int[] sample1 = new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
        System.out.println(maxMin(4, sample1));
    }


    // Complete the maxMin function below.
    static int maxMin(final int k, final int[] arr) {
        // We must sort the array from low to high, and that's it.
        Arrays.sort(arr);
        // Since we have the sorted array, we are going just calculate the consecutive k ones,
        // but only the minimum and top.
        int result = Integer.MAX_VALUE;
        int i = 0, temp;

        while ((i + k -1) < arr.length) {
            temp = arr[i+k-1] - arr[i];
            if (result > temp) {
                result = temp;
            }
            i++;
        }

        return result;
    }

}
