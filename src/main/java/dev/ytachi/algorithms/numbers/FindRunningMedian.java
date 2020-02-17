package dev.ytachi.algorithms.numbers;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindRunningMedian {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            int aCount = scanner.nextInt();
            PriorityQueue<Integer> min = new PriorityQueue<>();// Min-heap will contain the maximum half of the numbers from the array.
            PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));// Max-heap will contain the minimum half of the numbers from the array.
            /**
             * So the top value from the min-heap will be the minimum number from the max half of the array.
             * The top value from the max-heap will be the maximum number from the min half of the array.
             */


            for (int aItr = 0; aItr < aCount; aItr++) {
                final int aItem = scanner.nextInt();
                add(min, max, aItem);
            }
        }
    }

    /***
     * 6
     *
     * 12
     * 4
     * 5
     * 3
     * 8
     * 7
     *
     * @param min
     * @param max
     * @param i
     */
    static void add(PriorityQueue<Integer> min, PriorityQueue<Integer> max, int i) {
        if (max.isEmpty() || i < max.peek()) {
            max.add(i);
        } else {
            min.add(i);
        }

        PriorityQueue<Integer> bigHeap = max.size() > min.size() ? max : min;
        PriorityQueue<Integer> smallHeap = max.size() <= min.size() ? max : min;

        if (bigHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(bigHeap.poll());
        }

        if (smallHeap.size() == bigHeap.size()) {
            double res = (((double) smallHeap.peek()) + bigHeap.peek()) / 2;
            System.out.println(res);
        } else {
            System.out.println((double) bigHeap.peek());
        }

    }

}
