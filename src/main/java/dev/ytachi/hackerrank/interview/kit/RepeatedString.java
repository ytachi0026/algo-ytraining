package dev.ytachi.hackerrank.interview.kit;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
 */
public class RepeatedString {

    public static void main(String[] args) {
        System.out.println("Repeated String");

        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000l));

    }


    static long repeatedString(final String s, final long n) {
        if (n < 1 || n > Math.pow(10,12)) return -1;
        long rpta = 0;

        // 1. let's count the a's on the String s
        final int asString = s.chars().reduce(0, (subtotal, element) -> {
            if (element == 'a') {
                subtotal++;
            }
            return subtotal;
        });

        final long repeatsString = n / s.length();
        final long rest = n % s.length();

        rpta =  asString * repeatsString;

        if (rest != 0) {
            // we have to find the number of a on the substring
            final int restAs = s.substring(0, (int) rest).chars().reduce(0, (subtotal, element) -> {
                if (element == 'a') {
                    subtotal++;
                }
                return subtotal;
            });

            rpta += restAs;
        }

        return rpta;
    }
}
