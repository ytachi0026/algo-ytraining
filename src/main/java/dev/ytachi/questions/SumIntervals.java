package dev.ytachi.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.codewars.com/kata/52b7ed099cdc285c300001cd/train/java
 *
 */
public class SumIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}, {16, 19}, {1, 6}, {10, 20}, {5, 11}};
        System.out.println("SOLUTION: " + sumIntervals(intervals));
        System.out.println("SOLUTION BETTER: " + sumIntervalsBetter(intervals));
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null) return 0;

        List<Integer> values = new ArrayList<>();

        for (int[] row : intervals) {
            System.out.println("{" + row[0] +"," + row[1] + "}");
            for (int k = row[0]; k < row[1]; k++) {
                if (!values.contains(k)) {
                    values.add(k);
                }
                System.out.println(k);
            }
        }
        return values.size();
    }

    /**
     * https://stackoverflow.com/questions/70711542/execution-time-out-12000-ms-for-the-task-sum-of-intervals-codewars
     * Great pseudocode to work on
     * @param intervals
     * @return
     */
    public static int sumIntervalsBetter(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0; // :) 0 is the error code for CODE WARS!
        // Sorting for performance
        Arrays.sort(intervals, Comparator.comparing(a -> a[0])); // Java 8 style baby

        int sum = 0, currentStart = intervals[0][0], currentEnd = intervals[0][1];

        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index][0] > currentEnd) {
                sum += currentEnd - currentStart;
                currentStart = intervals[index][0];
                currentEnd = intervals[index][1];
            } else {
                currentEnd = Integer.max(currentEnd, intervals[index][1]);
            }
        }
        sum += currentEnd - currentStart;
        return sum;
    }

}
