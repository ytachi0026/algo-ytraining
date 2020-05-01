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

    static int sort(int[] array, int left, int right) {
        int count = 0;

        if (left < right) {
            // Let's find the middle point
            final int middle = (left + right) / 2;

            // Sort the left halve
            count += sort(array, left, middle);

            // Sort the right halve
            count += sort(array, middle + 1, right);

            // Merge the sorted halves
            count += mergeAndCount(array, left, middle, right);
        }

        return count;
    }

    static int mergeAndCount(int[] array, int left, int middle, int right) {
        final int leftArraySize = middle - left + 1;
        final int rightArraySize = right - middle;
        int L[] = new int [leftArraySize];
        int R[] = new int [rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            L[i] = array[left + i];
        }

        for (int j = 0; j < rightArraySize; j++) {
            R[j] = array[middle + 1 + j];
        }

        // Let's merge them

        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;

        int swaps = 0;

        while (i < leftArraySize && j < rightArraySize) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;

                swaps += (middle + 1) - (left + i);
            }
            k++;
        }

        while (i < leftArraySize) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {
            array[k] = R[j];
            j++;
            k++;
        }

        return swaps;
    }


}
