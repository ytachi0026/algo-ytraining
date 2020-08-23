package dev.ytachi.hackerrank.interview.kit.string.manipulation;

/**
 * https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class CommonChid {

  /**
   * A string is said to be a child of a another string if it can be formed by deleting 0 or more
   * characters from the other string. Given two strings of equal length, what's the longest string
   * that can be constructed such that it is a child of both?
   *
   * @param args
   */
  public static void main(String[] args) {
    //
    System.out.println(commonChild("HARRY", "SALLY"));
    System.out.println(commonChild("SHINCHAN", "NOHARAAA"));
    System.out.println(commonChild("ABCDEF", "FBDAMN"));
  }


    // Complete the commonChild function below.
    // Solution on WIKIPEDIA: https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
    // You need to know how to do dynamic programming: https://www.youtube.com/watch?v=ItRZRx8kvwY

    static int commonChild(final String s1, final String s2) {
      int[][] T = new int[5001][5001];

      int m = s1.length();
      int n = s2.length();

      for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
          if (i == 0 || j == 0) {
            T[i][j] = 0;
          } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            T[i][j] = 1 + T[i - 1][j - 1];
          } else {
            T[i][j] = Math.max(T[i][j - 1], T[i - 1][j]);
          }
        }
      }

        return T[m][n];
    }

  /**
   * Doesn't work like charm
   * @param s1
   * @param s2
   * @return
   */
    static int bruteForceCommonChild(final String s1, final String s2) {
      int count = 0;

      int j, lastFound = 0;
      for (int i = 0; i < s1.length(); i++) {
        char current = s1.charAt(i);

        for (j = lastFound; j < s2.length(); j++) {
          if (current == s2.charAt(j)) {
            count++;
            lastFound = j + 1;
            break;
          }
        }
      }
      return count;
    }
}

