package dev.ytachi.hackerrank.interview.kit.sorting;

public class MergeSort {

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};
        printArray(arr);
        sort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    static void printArray(final int arr[]) {
        final int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    static void sort(int[] array, int left, int right) {
        if (left < right) {
            // Let's find the middle point
            final int middle = (left + right) / 2;

            // Sort the left halve
            sort(array, left, middle);

            // Sort the right halve
            sort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }


    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int[] array, int left, int middle, int right) {
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

        while (i < leftArraySize && j < rightArraySize) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
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
    }
}
