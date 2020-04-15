package dev.ytachi.hackerrank.interview.kit.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("DEVYTACHI");
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        final int n = a.length;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
//                    swap(a[j], a[j + 1]);
                    counter++;
                    int current = a[j];
                    int next = a[j + 1];
                    a[j + 1] = current;
                    a[j] = next;
                }
            }
        }

        System.out.println(String.format("Array is sorted in %d swaps.", counter));
        System.out.println(String.format("First Element: %d", a[0]));
        System.out.println(String.format("Last Element: %d", a[n-1]));

    }

}
