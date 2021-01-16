package dev.ytachi.algorithms.strings;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 *
 * @author ytachi
 */
public class BalancedBrackets {
    // yeah you know, I am gonna use stacks!

    public static void main(String[] args) {
        final String test1 = "{[()]}";
        final String test2 = "{[(])}";
        final String test3 = "{{[[(())]]}}";
        final String test4 = "{{]";

        final BalancedBrackets test = new BalancedBrackets();
        System.out.println(test.isBalancedBrackets(test1));
        System.out.println(test.isBalancedBrackets(test2));
        System.out.println(test.isBalancedBrackets(test3));
        System.out.println(test.isBalancedBrackets(test4));

    }

    private boolean isMatchinPair(char c1, char c2) {
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        return false;
    }

    public String isBalancedBrackets(final String target) {
        final Stack<Character> stack = new Stack<>();

        for (final Character c : target.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return "NO";
                }

                if (isMatchinPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return "NO"; // this in case, there is a closing one without a partner.
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }

        return "NO";
    }

}
