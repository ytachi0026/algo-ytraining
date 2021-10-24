package dev.ytachi.hackerrank.interview.kit.arrays;

public class EncodeTestAWS {
    public static void main(String[] args) {
        System.out.println(encode("aaabbcc"));
        System.out.println(encode("aaabbc"));
        System.out.println(encode("abbc"));
        System.out.println(encode("aaaaaaaaaaaaaaabc"));
    }

    public static String encode(final String target) {
        final char[] targetChars = target.toCharArray();
        char prevChar = 0;
        int counter = 1;
        final StringBuilder result = new StringBuilder();

        for (char currentChar : targetChars) {
            if (currentChar == prevChar) {
                counter++;
            } else if (prevChar != 0) {
                result.append(counter).append(prevChar);
                counter = 1;
            }
            prevChar = currentChar;
        }

        result.append(counter).append(prevChar);
        return result.toString();
    }
}
