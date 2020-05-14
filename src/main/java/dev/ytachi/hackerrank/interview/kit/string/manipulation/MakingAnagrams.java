package dev.ytachi.hackerrank.interview.kit.string.manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

    public static void main(String[] args) {

        final int deletion = makeAnagram("cde", "abc");
        System.out.println("final: " + deletion);
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(final String a, final String b) {
        int deletionCount = 0;

        // make hash array for both string
        // and calculate frequency of each character, because we are gonna to solve this by deleting the same characters
        int count1[] = new int[26];// We know that the [a-z], i could have used map, but this is more memory efficient, since we have limited space
        int count2[] = new int[26];

        // count frequency of each character
        // in first string
        for (int i = 0; i < a.length(); i++) {
            count1[a.charAt(i) - 'a']++;// we are substracting the letters orders!
        }

        // count frequency of each character
        // in second string
        for (int i = 0; i < b.length(); i++) {
            count2[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            deletionCount += Math.abs(count1[i] - count2[i]);
        }

        return deletionCount;
    }
}
