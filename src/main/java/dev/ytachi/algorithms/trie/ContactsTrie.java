package dev.ytachi.algorithms.trie;

import java.util.ArrayList;
import java.util.List;

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

    static int[] contacts(String[][] queries) {
        final Trie trie = new Trie();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i< queries.length; i++){
            String action = queries[i][0];
            String contact = queries[i][1];
            if (action.equals("add")) {
                trie.add(contact);
            } else if (action.equals("find")) {
                result.add(trie.find(contact));
            }
        }

//        int all[] = new int[result.size()];
//        for (int i = 0; i< result.size(); i++) {
//            all[i] = result.get(i);
//        }
        return result.stream().mapToInt(i -> i).toArray();

    }
}
