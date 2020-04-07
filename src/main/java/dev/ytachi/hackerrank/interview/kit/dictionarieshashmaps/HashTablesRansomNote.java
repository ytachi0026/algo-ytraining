package dev.ytachi.hackerrank.interview.kit.dictionarieshashmaps;

import java.util.HashMap;
import java.util.Map;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 * If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value. Otherwise, replaces the associated value with the results of the given remapping function, or removes if the result is null.
 * This method may be of use when combining multiple mapped values for a key. For example, to either create or append a String msg to a value mapping:
 *
 */
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
