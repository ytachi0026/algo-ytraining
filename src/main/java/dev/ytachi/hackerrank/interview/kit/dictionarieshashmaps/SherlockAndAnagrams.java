package dev.ytachi.hackerrank.interview.kit.dictionarieshashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("kkkk"));

    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(final String s) {
        Map<String, Integer> mapping = new HashMap<>();

        /**
         * first obtain all the substring
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] valC = s.substring(i, j+1).toCharArray();
                Arrays.sort(valC); // as Anagrams can be reorder, lets' do it the simple way, order them
                mapping.merge(String.valueOf(valC), 1, Integer::sum);
            }
        }

        // second. since we have all the mapping done, we sum each frequency by this formula:
        // (n * (n -1 )) / 2

        final int counter = mapping.values().stream()
                .mapToInt((n) -> ((n * (n - 1)) / 2))
                .sum();

        return counter;

    }

}
