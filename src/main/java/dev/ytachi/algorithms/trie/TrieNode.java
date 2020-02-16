package dev.ytachi.algorithms.trie;

import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    public int size = 0;

    private String content;
    private boolean isWord;



    public void putChildIfAbsent(final char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(final char ch) {
        return children.get(ch);
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(final HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(final boolean word) {
        isWord = word;
    }
}
