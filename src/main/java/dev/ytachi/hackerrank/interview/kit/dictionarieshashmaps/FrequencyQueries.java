package dev.ytachi.hackerrank.interview.kit.dictionarieshashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyQueries {

    public static void main(String[] args) {

    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        final List<Integer> result = new ArrayList<>();

        final Map<Integer, Integer> mapping = new HashMap<>();
        final Map<Integer, Integer> frequencies = new HashMap<>();

        Integer operation, key, partial, frecuenciaActual;
        for (final List<Integer> query : queries) {
            operation = query.get(0);
            key = query.get(1);

            if (operation == 1) {
                if (mapping.containsKey(key)) {
                    frecuenciaActual = mapping.get(key);
                    frequencies.merge(frecuenciaActual, 1, (a, b) -> a - b);
                    mapping.put(key, mapping.get(key) + 1);
                } else {
                    mapping.put(key, 1);
                }
                frequencies.merge(mapping.get(key), 1, Integer::sum);
            } else if (operation == 2) {
                if (mapping.keySet().contains(key) && mapping.get(key) > 0) {
                    frecuenciaActual = mapping.get(key);
                    frequencies.merge(frecuenciaActual, 1, (a, b) -> a - b);
                    mapping.put(key, mapping.get(key) - 1);
                    frequencies.merge(mapping.get(key), 1, Integer::sum);
                }
            } else if (operation == 3) {
                partial = frequencies.get(key) != null && frequencies.get(key) > 0 ? 1 : 0;
                result.add(partial);
            }
        }

        return result;
    }
}
