package dev.ytachi.hackerrank.interview.kit.sorting;

public class MarkAndToys {

    public static void main(String[] args) {

    }

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int toysToBuy = 0;
        int spentMoney = 0;

        QuickSort.quickSort(prices, 0, prices.length - 1);

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



}
