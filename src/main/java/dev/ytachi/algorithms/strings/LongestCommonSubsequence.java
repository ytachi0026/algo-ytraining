package dev.ytachi.algorithms.strings;

/**
 * @author ytachi
 * Learning how to handle LCS problems, thanks to Java AAID!
 * Youtube: https://www.youtube.com/watch?v=DuikFLPt8WQ
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        final String s1 = "JAVAAID";
        final String s2 = "JAVAID";
        System.out.println("1- Recursive method ");
        System.out.println(LCM1(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println("2- Recursive method with memoization");
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];
        System.out.println(LCM2(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), dp));
        System.out.println("3- Using bottom-up approach ");
        System.out.println(LCM3(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println("4- Using bottom-up approach, with better performance");
        System.out.println(LCM4(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }

    /**
     *  Using recursive to solve this out
     *  Time complexity: O(2 ^ (i+ j))
     *  Space complexity: O(j + j)
     */
    public static int LCM1(char[] s1, char[]s2, int i, int j) {
        if (i <= 0 || j <= 0) {
            return 0;
        } else if (s1[i-1] == s2[j-1]) {
            return 1 + LCM1(s1, s2, i-1, j-1);
        } else {
            return Math.max(LCM1(s1, s2, i, j - 1), LCM1(s1, s2, i - 1, j));
        }
    }

    /**
     *  Using recursive with memoization to solve this out
     *  Time complexity: O(2 ^ (i+ j))
     *  Space complexity: O(j + j)
     */
    public static int LCM2(char[] s1, char[]s2, int i, int j, Integer[][] dp) {
        if (i <= 0 || j <= 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1[i-1] == s2[j-1]) {
            return 1 + LCM2(s1, s2, i-1, j-1, dp);
        } else {
            return dp[i][j] = Math.max(LCM2(s1, s2, i, j - 1, dp), LCM2(s1, s2, i - 1, j, dp));
        }
    }

    /**
     *  Using bottom up approach to solve this out
     *  Time complexity: O(j*j) =>  2 loops
     *  Space complexity: O(j*i)
     */
    public static int LCM3(char[] s1, char[]s2, int i, int j) {
        int[][] memo = new int[i + 1][j + 1];
        for (int m = 0; m <= i; m++) {
            for (int n = 0; n <= j; n++) {
                if (m == 0 || n == 0) {
                    memo[m][n] = 0;
                } else if (s1[m - 1] == s2[n - 1]) {
                    memo[m][n] = memo[m - 1][n - 1] + 1;
                } else {
                    memo[m][n] = Math.max(memo[m - 1][n], memo[m][n - 1]);
                }
            }
        }

        return memo[i][j];
    }


    /**
     *  Using bottom up approach to solve this out
     *  Time complexity: O (m*n)
     *  Space complexity: O (n)
     */
    public static int LCM4(char[] s1, char[]s2, int i, int j) {
        int[] memo = new int[j + 1];
        for (int m = 1; m <= i; m++) {
            int prev = 0;
            for (int n = 1; n <= j; n++) {
                int temp = memo[n];
                if (s1[m - 1] == s2[n - 1]) {
                    memo[n] = prev + 1;
                } else {
                    memo[n] = Math.max(memo[n], memo[n - 1]);
                }
                prev = temp;
            }
        }

        return memo[j];
    }
}
