package dev.ytachi.hackerrank.interview.kit.arrays;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 */
public class Arrays2D {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        final int n = 6;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j <  -2 ; j++) {
                int temp = hourglassSum(arr, i, j);
                if (temp > maxSum) {
                    maxSum = temp;
                }
            }
        }

        return maxSum;
    }

    static int hourglassSum(final int[][] arr, final int i, final int j) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                + arr[i + 1][j + 1]
                + arr[i+2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }

}
