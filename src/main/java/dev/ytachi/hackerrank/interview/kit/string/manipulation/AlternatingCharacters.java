package dev.ytachi.hackerrank.interview.kit.string.manipulation;

/**
 * Alternating Characters
 * https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class AlternatingCharacters {
    public static void main(String[] args) {

    }


    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int deletionCount = 0;

        int index = 1;
        final char[] sData = s.toCharArray();
        char current = sData[0];
        while (index < s.length()) {
            if (current == sData[index]) {
                deletionCount++;
            } else {
                current = sData[index];
            }
            index++;
        }
        return deletionCount;
    }


}
