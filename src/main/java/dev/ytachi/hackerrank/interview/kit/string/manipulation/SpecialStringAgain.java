package dev.ytachi.hackerrank.interview.kit.string.manipulation;

/**
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 *
 * Solution: https://www.geeksforgeeks.org/count-special-palindromes-in-a-string/
 */
public class SpecialStringAgain {

    public static void main(String[] args) {

//              System.out.printf(substrCount(7, "abcbaba") + "");
      System.out.printf(substrCount(6, "aabaaa") + "");

    }

    // Complete the substrCount function below.
    static long substrCount(final int n, final String s) {
        long result = 0;

        int[] sameChar = new int[n];

        int i = 0;

        while (i < n) {
            int sameCharCount = 1;
            int j = i + 1;
            while (j < n && s.charAt(i) == s.charAt(j)) {
                sameCharCount++;
                j++;
            }
          // Case 1: All Palindromic substrings have same character :
          // We can handle this case by simply counting the same continuous character and using formula
          // K*(K+1)/2 (total number of substring possible : Here K is count of Continuous same char).
          result += (sameCharCount * (sameCharCount + 1) / 2);
            sameChar[i] = sameCharCount;
            i = j;
        }



        for (int j = 1; j < n; j++) {
            if (s.charAt(j) == s.charAt(j - 1)) {
                sameChar[j] = sameChar[j - 1];
            }

            // case 2: odd length
            if (j > 0 && j < (n - 1) && (s.charAt(j - 1) == s.charAt(j + 1) && s.charAt(j) != s.charAt(j - 1))) {
                result += Math.min(sameChar[j - 1], sameChar[j + 1]);
            }
        }

        return result;
    }

}
