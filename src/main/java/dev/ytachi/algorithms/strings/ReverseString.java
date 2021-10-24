package dev.ytachi.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseString {

    public static void main(String[] args) {
        final String toBeReversed = "123456789";
        final char[] data = toBeReversed.toCharArray();
        System.out.println("TEST 1");
        IntStream.range(0, data.length)
                .mapToObj(i -> data[(data.length - 1) - i])
                .forEach(System.out::print);

        System.out.println("\nTEST 2");
        final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        final List<Integer> numbersList = Arrays.asList(numbers);
        Integer result = numbersList.stream().reduce(0, (current, accumulator) -> {
            accumulator += current;
            return accumulator;
        });

        System.out.println(result);

    }
}
