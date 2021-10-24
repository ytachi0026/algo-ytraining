package dev.ytachi.algorithms.list;

public class Find2ndLowestBiggest {
    public static void main(String[] args) {
        find2ndLowestAndBiggest(new int[]{1,2,3,4,5,6});
        find2ndLowestAndBiggestBetter(new int[]{1,2,3,4,5,6});

    }

    /**
     * solution O(n) with 2 traverse
     * @param target
     */
    public static void find2ndLowestAndBiggest(final int[] target) {
        int index, firstBiggest, secondBiggest, firstLowest, secondLowest;

        firstBiggest = secondBiggest = Integer.MIN_VALUE;
        firstLowest = secondLowest = Integer.MAX_VALUE;
        for (index = 0; index < target.length; index++) {
            if (target[index] > firstBiggest) {
                firstBiggest = target[index];
            }

            if (target[index] < firstLowest) {
                firstLowest = target[index];
            }
        }

        for (index = 0; index < target.length; index++) {
            if (target[index] > secondBiggest && target[index] != firstBiggest) {
                secondBiggest = target[index];
            }

            if (target[index] < secondLowest && target[index] != firstLowest) {
                secondLowest = target[index];
            }
        }

        System.out.println("secondBiggest:" + secondBiggest);
        System.out.println("secondLowest:" + secondLowest);
    }

    /**
     * solution O(n) with 1 traverse
     * @param target
     */
    public static void find2ndLowestAndBiggestBetter(final int[] target) {
        int index, firstBiggest, secondBiggest, firstLowest, secondLowest;

        firstBiggest = secondBiggest = Integer.MIN_VALUE;
        firstLowest = secondLowest = Integer.MAX_VALUE;
        for (index = 0; index < target.length; index++) {
            if (target[index] > firstBiggest) {
                secondBiggest = firstBiggest;
                firstBiggest = target[index];
            } else if (target[index] > secondBiggest && target[index] != firstBiggest) {
                secondBiggest = target[index];
            }

            if (target[index] < firstLowest) {
                secondLowest = firstLowest;
                firstLowest = target[index];
            } else if (target[index] < secondLowest && target[index] != firstLowest) {
                secondLowest = target[index];
            }
        }

        System.out.println("secondBiggest:" + secondBiggest);
        System.out.println("secondLowest:" + secondLowest);
    }
}
