package dev.ytachi.hackerrank.interview.kit.dictionarieshashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.youtube.com/watch?v=tBFZMaWP0W8&t=777s
public class CountTriplets {

    public static void main(String[] args) {

        System.out.println(countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5));

        System.out.println(countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3));

        System.out.println(countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 4));

        System.out.println(countTriplets(Arrays.asList(1L, 2L, 2L, 4L, 4L, 8L), 2));

        System.out.println(countTriplets(Arrays.asList(1L, 4L, 16L, 64L), 4));

        System.out.println(countTriplets(Arrays.asList(1L, 3L, 3L, 9L, 9L, 9L, 27L, 81L), 3));

    }

    // Complete the countTriplets function below.
    static long countTriplets(final List<Long> arr, final long r) {
        long counter = 0;

        final Map<Long, Integer> rightMap = new HashMap<>();
        for (Long data : arr) { // right map will have the frequencies
            rightMap.merge(data, 1, Integer::sum);
        }

        final Map<Long, Integer> leftMap = new HashMap<>();

        // let's transverse the whole array
        for (int i = 0; i < arr.size(); i++) {
            long mid = arr.get(i);
            long freqPrev = 0, freqNext = 0;

            rightMap.put(mid, rightMap.get(mid) - 1);

            if ((mid % r == 0) && leftMap.containsKey(mid / r)) {
                freqPrev = leftMap.get(mid / r);
            }
            if (rightMap.containsKey(mid * r)) {
                freqNext = rightMap.get(mid * r);
            }

            counter += (freqNext * freqPrev);
            leftMap.merge(mid, 1, Integer::sum);
        }
        return counter;
    }


}
