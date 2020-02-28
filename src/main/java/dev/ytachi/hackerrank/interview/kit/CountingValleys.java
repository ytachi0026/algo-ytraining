package dev.ytachi.hackerrank.interview.kit;

public class CountingValleys {
    public static void main(final String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
        System.out.println("**");
        System.out.println(countingValleysBetterApproach(8, "UDDDUDUU"));
        System.out.println(countingValleysBetterApproach(12, "DDUUDDUDUUUD"));
    }

    static int countingValleysBetterApproach(final int n, final String s) {
        int valley = 0, altitude = 0;
        for (int i = 0; i < n; i++) {
            if ('U' == s.charAt(i)) {
                altitude++;
                if (altitude == 0) {
                    valley++;
                }
            } else {
                altitude--;
            }
        }
        return valley;
    }


    // Complete the countingValleys function below.
    static int countingValleys(final int n, final String s) {
        if (n < 2 || n > Math.pow(10,6)){
            return -1;
        }
        if (n != s.length()){
            return -1;
        }

        // I am gonna use an stack for this.

        int level = 0;
        int valleys = 0;
        for (int i = 0; i < n; i++) {
            final char step = s.charAt(i);
            if (step == 'U') {
                level++;
            }
            if (step == 'D') {
                level--;
            }
            if (level < 0) {
                // can i get out?
                int j = i+1;
                while (j<n && level != 0){
                    final char nextStep = s.charAt(j);
                    if (nextStep =='U') {
                        level++;
                    }
                    if (nextStep == 'D') {
                        level--;
                    }
                    j++;
                }
                valleys++;
                i=j-1;
            }
        }
        return valleys;
    }

}
