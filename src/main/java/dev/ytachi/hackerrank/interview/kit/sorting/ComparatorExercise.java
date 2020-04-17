package dev.ytachi.hackerrank.interview.kit.sorting;

import java.util.Comparator;

public class ComparatorExercise {

    public static void main(String[] args) {

    }


}


class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {

        if (a.score < b.score) {
            return -1;
        }

        if (a.score > b.score) {
            return 1;
        }

        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        return 0;
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
