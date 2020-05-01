package dev.ytachi.hackerrank.interview.kit.sorting;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Key concept: https://en.wikipedia.org/wiki/Median#Basic_procedure
 * Median!
 *
 */
public class FraudulentActivityNotifications {

    public static void main(String[] args) {
        int medium = (int) Math.floor(6 / 2);
        System.out.println("Medium: " + medium);

        int[] test1 = new int[]{1, 2, 3, 4, 4};
        activityNotifications(test1, 4);
    }


    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        final int n = expenditure.length;

        final Queue<Integer> queue = new LinkedList<>();
        int[] pastActivity = new int[201];

        for (int i = 0; i < d; i++) {
            queue.offer(expenditure[i]);
            pastActivity[expenditure[i]] += 1;
        }

        double median;
        for (int i = d; i < n; i++) {
            median = median(pastActivity, d);

            int newestTransaction = expenditure[i];
            if (newestTransaction >= 2 * median) {
                notifications++;
            }

            int oldestTransaction = queue.poll();
            pastActivity[oldestTransaction] -= 1;

            queue.offer(newestTransaction);
            pastActivity[newestTransaction] += 1;
        }

        return notifications;
    }

    static double medianBetter(int[] countingSort, int elements) {

        // Calcula media position
        final int mediaPosition;

        if (elements % 2 == 0) {
            mediaPosition = elements / 2;
        } else {
            mediaPosition = (elements / 2) + 1;
        }

        int counter = 0, left = 0;

        while (counter < mediaPosition) {
            counter += countingSort[left];
            left++;
        }

        int right = left;
        left--;

        // if odd, or both left and right of even are same number
        if (counter > mediaPosition || elements % 2 != 0) {
            return left;
        } else {
            while (countingSort[right] == 0) {
                right++;
            }
            return (left + right) / 2;
        }
    }


    static double median(int[] array, int elements) {
        int index = 0;
        int counter = (elements / 2);

        if (elements % 2 == 0) {
            while (counter > 0) {
                counter -= array[index];
                index++;
            }

            index--;//Remove extra iteration

            if (counter <= -1) {//This index covers both medians
                return index;
            } else {//(counter == 0) We need to find the next median index
                int firstIndex = index;
                int secondIndex = index + 1;
                while(array[secondIndex] == 0) {//Find next non-zero transaction
                    secondIndex++;
                }
                return (double) (firstIndex + secondIndex) / 2.0;//Calculate the average of middle two elements
            }
        } else { //Find median of odd # of elements
            while(counter >= 0) {
                counter -= array[index];
                index++;
            }
            return (double) index-1;
        }
    }
}
