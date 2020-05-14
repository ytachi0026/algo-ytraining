package dev.ytachi.hackerrank.interview.kit.sorting;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 *
 * Theory: https://www.geeksforgeeks.org/merge-sort/
 *
 */
public class MergeSortCountingInversions {
    public static void main(String[] args) {

    }

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        /* Our array chas up to n= 100 000 elements. So, there might be O(n^2) inversions. n^2 is 10,000,000,000.
        A Java int has max value 2,147,483,647 so we use a long to avoid integer overflow */
        final long inversions = mergeSortAndCount(arr, temp, 0, arr.length - 1);
        return inversions;
    }


    // OPTION A
    static long mergeSortAndCount(int[] array, int[] temp, int left, int right) {
        long inversionCount = 0;

        if (left < right) {
            // Let's find the middle point
            final int middle = (left + right) / 2;

            // Sort the left halve
            inversionCount += mergeSortAndCount(array, temp, left, middle);

            // Sort the right halve
            inversionCount += mergeSortAndCount(array, temp, middle + 1, right);

            // Merge the sorted halves
            inversionCount += mergeAndCount(array, temp, left, middle + 1, right);
        }

        return inversionCount;
    }

    static long mergeAndCount(int[] array, int[] temp, int left, int middle, int right) {
        int i, j, k;
        long inversionCount = 0;

        i = left;//index of the left
        j = middle;//index of the right
        k = left;//index of the merged array

        while ((i <= middle - 1) && (j <= right)) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                inversionCount += middle - i;
            }
        }

        while (i <= middle - 1) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (int x = left; x <= right; x++) {
            array[x] = temp[x];
        }

        return inversionCount;
    }

    // OPTION B
    // https://poopcode.com/hackerrank-solutions-merge-sort-counting-inversions-java-solution/, this guy was a huge help!
    static long mergeSortAndCountB(int[] array, int left, int right) {
        long inversionCount = 0;

        if (left < right) {
            // Let's find the middle point
            final int middle = (left + right) / 2;

            // Sort the left halve
            inversionCount += mergeSortAndCountB(array, left, middle);

            // Sort the right halve
            inversionCount += mergeSortAndCountB(array, middle + 1, right);

            // Merge the sorted halves
            inversionCount += mergeAndCountB(array, left, middle, right);
        }

        return inversionCount;
    }


    static long mergeAndCountB(int[] array, int left, int middle, int right) {
        long inversionCount = 0;
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0;//index of the leftArray
        int j = 0;//index of the rightArray
        int k = left;// index of the mergedArray

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
                inversionCount += (middle + 1) - (left + i);
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }

        return inversionCount;
    }


}
