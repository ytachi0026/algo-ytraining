package dev.ytachi.hackerrank.interview.kit.dictionarieshashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashTablesRansomNote {

    public static void main(String[] args) {

    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Long> magazineMap = new HashMap<>();

        for (int i = 0; i < magazine.length; i++) {
            magazineMap.merge(magazine[i], 1L, Long::sum);
        }

        for (int j = 0; j < note.length; j++) {
            final String ransomWord = note[j];

            if(!magazineMap.containsKey(ransomWord) || magazineMap.get(ransomWord) == 0) {
                System.out.println("No");
                return;
            } else {
                Long newfrequency = magazineMap.get(ransomWord).longValue() - 1L;
                magazineMap.put(ransomWord, newfrequency);
            }
        }

        System.out.println("Yes");
    }

}
