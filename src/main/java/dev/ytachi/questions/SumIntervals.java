package dev.ytachi.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/52b7ed099cdc285c300001cd/train/java
 *
 */
public class SumIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}, {16, 19}, {1, 6}, {10, 20}, {5, 11}};
        System.out.println(sumIntervals(intervals));
    }

    public static int sumIntervals(int[][] intervals) {
        List values = new ArrayList();

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

}
