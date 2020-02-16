package dev.ytachi.algorithms.trie;

/**
 * Resources:
 * https://www.baeldung.com/trie-java
 * https://www.hackerrank.com/challenges/contacts/forum/comments/255027
 * https://www.geeksforgeeks.org/trie-insert-and-search/
 */
public class Trie {
    private TrieNode root = new TrieNode();

    public void add(final String target) {
        TrieNode curr = root;
        for (final char ch : target.toCharArray()) {
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        TrieNode curr = root;
        for (final char ch : prefix.toCharArray()) {
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(final TrieNode root) {
        this.root = root;
    }
}
