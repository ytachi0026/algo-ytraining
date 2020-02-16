package dev.ytachi.algorithms.trie;


/**
 * https://www.hackerrank.com/challenges/contacts/problem
 *
 * @author ytachi
 */
public class ContactsTrie {

    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.add("hacker");
        trie.add("hackerrank");

        System.out.println(trie.find("hack"));
        System.out.println(trie.find("hak"));
    }
}
