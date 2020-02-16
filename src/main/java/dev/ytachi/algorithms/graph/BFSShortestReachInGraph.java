package dev.ytachi.algorithms.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Breadth First Search or BFS for a Graph
 *
 *
 * @author ytachi
 */
public class BFSShortestReachInGraph {

    public static void main(String[] args) {
        final Graph test = new Graph(4);
        test.addEdge(0, 1);
        test.addEdge(0, 2);
        test.addEdge(1, 2);
        test.addEdge(2, 0);
        test.addEdge(2, 3);
        test.addEdge(3, 3);

        test.BFS(2);
    }
}

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
 */
class hackerRankProblem {
    public static void main(String[] args) {
        // since i am bit lazy, i'll just start my node on 0, and hackerrank starts on 1, our answer will show the vertex + 1. :)

        final Graph test = new Graph(6);
        test.addEdge(0, 1);
        test.addEdge(1, 2);
        test.addEdge(2, 3);
        test.addEdge(0, 4);

        test.BFSHackerRank(0);

    }
}

class Graph {
    private int V; // number of vertices
    private LinkedList<Integer> adjacent[];

    // Basically according with Greek to Geek we will have an array, where each element of the array will be a LinkedList.
    // [LL, LL, LL] => That's smart!

    Graph(final int v) {
        this.V = v;
        adjacent = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacent[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int vertexEnd) {
        this.adjacent[vertex].add(vertexEnd);
    }

    public void BFS(final int vertexSource) {
        // As you know graph are different from trees, we might find recursion, so we need a set, in order to avoid revisiting a vertex.
        // it is quite similar to sptSet of Dijkstra

        boolean visited[] = new boolean[V];

        // As theory says, the key concept to do this BFS is a queue, so let's do it
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertexSource] = true;
        queue.add(vertexSource);

        Integer current;
        while (!queue.isEmpty()) {
            current = queue.pop();

            System.out.println(current + "");
            // let's iterate all the adjacent vertices to pop in on our famous queue

            for (final Integer vertix : this.adjacent[current]) {
                if (!visited[vertix]) { // important to avoid unnecessary cycles
                    visited[vertix] = true;
                    queue.add(vertix);
                }
            }
        }
    }


    public void BFSHackerRank(final int vertexSource) {
        // As you know graph are different from trees, we might find recursion, so we need a set, in order to avoid revisiting a vertex.
        // it is quite similar to sptSet of Dijkstra

        boolean visited[] = new boolean[V];
        int weightTravel[] = new int[V];
        // -1 represent that we can't reach that node :(, and at the beginning sound good right?
        Arrays.fill(weightTravel, -1);

        // As theory says, the key concept to do this BFS is a queue, so let's do it
        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertexSource] = true;
        weightTravel[vertexSource] = 0;
        queue.add(vertexSource);

        Integer current;
        while (!queue.isEmpty()) {
            current = queue.pop();

            // let's iterate all the adjacent vertices to pop in on our famous queue
            for (final Integer vertix : this.adjacent[current]) {
                if (!visited[vertix]) { // important to avoid unnecessary cycles
                    visited[vertix] = true;
                    queue.add(vertix);
                    weightTravel[vertix] = weightTravel[current] + 6;
                }
            }
        }

        // Print what Hacker rank wants
        // Remember that I created this little guy: weightTravel
        for (int i = 0; i < V; i++) {
            System.out.println(String.format("Verterx %d, travel: %d", i + 1, weightTravel[i]));
        }
    }
}
