package dev.ytachi.hackerrank.interview.kit;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 *
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        System.out.println("Jumping on the clouds");

        final int[] input = new int[] {0, 0, 1, 0, 0, 1, 0};

        System.out.println(jumpingOnClouds(input));
    }

    static int jumpingOnClouds(int[] c) {
        final int n = c.length;
        if (n < 2 || n > 100) return -1;
        if (c[0] != 0 || c[n -1] != 0) return -1;

        int jumps = 0;
        int i = 0;
        while( i != n - 1) {
            // TODO jump 2
            if (i + 2 < n && c[i + 2] == 0) {
                jumps++;
                i = i + 2;
                continue;
            }
            // TODO jump 1
            if (i + 1 < n && c[i + 1] == 0) {
                jumps++;
                i = i + 1;
                continue;
            }
        }
        return jumps;
    }


}
