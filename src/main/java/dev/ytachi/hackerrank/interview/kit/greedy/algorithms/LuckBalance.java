package dev.ytachi.hackerrank.interview.kit.greedy.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LuckBalance {

    public static void main(String[] args) {

    }


    // Complete the luckBalance function below.
    // k: the number of important contests Lena can lose
    static int luckBalance(int k, int[][] contests) {
        int maxLuck = 0;
        // I think i need to sort the contest
        final List important = new ArrayList<Integer>();

        for (int i = 0; i < contests.length; i++) {
            // You are loosing all the unimportant ones!
            if (contests[i][1] == 0) {
                maxLuck += contests[i][0];
            } else {
                important.add(contests[i][0]);
            }
        }

        //Sort the important contests in descending order
        Collections.sort(important, Collections.reverseOrder());

        //Lose the k largest contests and win the rest
        // because if you lose the important contest, you win LUCK!!, and to maximise, you need luck!
        for (int i = 0; i < important.size(); i++) {
            if (i < k) {
                maxLuck += (int) important.get(i);
            } else {
                maxLuck -= (int) important.get(i);
            }
        }

        return maxLuck;
    }
}
