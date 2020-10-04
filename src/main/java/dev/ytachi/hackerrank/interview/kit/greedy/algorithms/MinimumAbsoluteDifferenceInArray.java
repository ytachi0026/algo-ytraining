package dev.ytachi.hackerrank.interview.kit.greedy.algorithms;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInArray {

    public static void main(String[] args) {
        int[] sample1 = new int[]{3, -7, 0};
        System.out.println(minimumAbsoluteDifference(sample1));
    }

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifferenceInneficient(int[] arr) {
        int minimumAbsoluteDifference = Integer.MAX_VALUE;
        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                temp = Math.abs(arr[i] - arr[j]);
                if (minimumAbsoluteDifference > temp) {
                    minimumAbsoluteDifference = temp;
                }
            }
        }
        return minimumAbsoluteDifference;
    }

    // This is also an easy problem. Take a vector and sort it and find the minimum difference of adjacent element(as vector is sorted).
    static int minimumAbsoluteDifference(int[] arr) {
        int minimumAbsoluteDifference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            minimumAbsoluteDifference = Math.min(minimumAbsoluteDifference, Math.abs(arr[i] - arr[i - 1]));
        }
        return minimumAbsoluteDifference;
    }

}
