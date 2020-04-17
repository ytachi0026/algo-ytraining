package dev.ytachi.hackerrank.interview.kit.sorting;

public class MarkAndToys {

    public static void main(String[] args) {

    }


    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int toysToBuy = 0;
        int spentMoney = 0;

        quickSort(prices, 0, prices.length);

        for (int i = 0; i < prices.length; i++) {
            spentMoney += prices[i];
            if (spentMoney <= k) {
                toysToBuy++;
            } else {
                break;
            }

        }

        return toysToBuy;
    }

    /**
     * In detail: https://www.baeldung.com/java-quicksort
     * The first method is quickSort() which takes as parameters the array to be sorted, the first and the last index. First, we check the indices and continue only if there are still elements to be sorted.
     * @param arr
     * @param begin
     * @param end
     */
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

}
