package dev.ytachi.hackerrank.interview.kit.dictionarieshashmaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoStrings {

    public static void main(String[] args) {

    }

    /**
     * KEY: Remember we have only 24 characters, lets' handle the string as a Set
     * @param s1
     * @param s2
     * @return
     */
    static String twoStringSmartWay(String s1, String s2) {

        final Set<Character> s1Set = new HashSet<>();
        final Set<Character> s2Set = new HashSet<>();
        for (Character c : s1.toCharArray()) {
            s1Set.add(c);
        }

        for (Character c : s2.toCharArray()) {
            s2Set.add(c);
        }

        /**
         * Key concept: retainAll https://docs.oracle.com/javase/8/docs/api/java/util/Set.html#retainAll-java.util.Collection-
         *
         * boolean retainAll(Collection<?> c)
         * Retains only the elements in this set that are contained in the specified collection (optional operation). In other words, removes from this set all of its elements that are not contained in the specified collection. If the specified collection is also a set, this operation effectively modifies this set so that its value is the intersection of the two sets.
         * Specified by:
         * retainAll in interface Collection<E>
         * Parameters:
         * c - collection containing elements to be retained in this set
         * Returns:
         * true if this set changed as a result of the call
         * Throws:
         * UnsupportedOperationException - if the retainAll operation is not supported by this set
         * ClassCastException - if the class of an element of this set is incompatible with the specified collection (optional)
         * NullPointerException - if this set contains a null element and the specified collection does not permit null elements (optional), or if the specified collection is null
         * See Also:
         * remove(Object)
         */
        s1Set.retainAll(s2Set);
        if (!s1Set.isEmpty()) {
            return "YES";
        }
        return "NO";

    }

    // BRUTE force
    static String twoStrings(String s1, String s2) {

        for (char c : s2.toCharArray()) {
            if (s1.contains(String.valueOf(c))) {
                return "YES";
            }
        }

        return "NO";
    }

}
