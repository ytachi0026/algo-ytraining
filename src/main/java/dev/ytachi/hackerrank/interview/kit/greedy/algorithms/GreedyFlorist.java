package dev.ytachi.hackerrank.interview.kit.greedy.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ytachi0026
 * URL https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class GreedyFlorist {
    // A group of friends want to buy a bouquet of flowers. The florist wants to maximize his number of new customers and the money he makes.
    public static void main(String[] args) {
        // Suite test case
        int[] c1 = new int[]{6, 2, 5};
        int[] c2 = new int[]{1,3,5,7,9};
//        getMinimumCost(3, c1);
//        getMinimumCost(2, c1);
        System.out.println("Greedy Florist");
        System.out.println(getMinimumCost(3, c2));

    }


    /**
     * Complete the getMinimumCost function below.
     * Observation, there is a limit within the answer, it says that should be less than 2^31, so, we will be using an INT
     * @param k, number of friends
     * @param c, cost of the flowers. OJO, the length of C represents the number of flowers (n)
     * @return
     */
    static int getMinimumCost(final int k, final int[] c) {
        int answer = 0;
        final int n = c.length; // the number of flowers
        // lest sort the price cost of the flowers
        Arrays.sort(c);
        // so we have an array sorted (ascending).

        int currentPuchase = 0;

        for (int i = n; i > 0; i--) {
            //we are going to sum the flowers price.
            if (i - k >= 0) { // we secure that the K friends can buy the flowers
                for (int j = 0; j < k; j++) {
                    answer += (currentPuchase + 1) * c[i - 1];
                    i--;
                }
                currentPuchase++;
                i++;//just to avoid the annoying -- on the for.
            } else {
                 // we are on the case that there is less flowers than the number of friends who want to buy them
                while (i > 0) {
                    answer += (currentPuchase + 1) * c[i - 1];
                    i--;
                }
            }
        }
        return answer;
    }




}
