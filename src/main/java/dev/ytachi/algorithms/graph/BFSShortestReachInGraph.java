package dev.ytachi.algorithms.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

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
//    public static void main(String[] args) {
//        // since i am bit lazy, i'll just start my node on 0, and hackerrank starts on 1, our answer will show the vertex + 1. :)
//        final Graph test = new Graph(6);
//        test.addEdge(0, 1);
//        test.addEdge(1, 2);
//        test.addEdge(2, 3);
//        test.addEdge(0, 4);
//
//        test.BFSHackerRank(0);
//    }

    public static void main(String[] args) {
        final Graph test = new Graph(7);
        test.addEdge(0, 1);
        test.addEdge(0, 2);
        test.addEdge(2, 3);
        test.addEdge(1, 4);

        test.BFSHackerRank(1);
    }
}

class Graph {
    private int V; // number of vertices
    private LinkedList<Integer> adjacent[];

    // Basically according with Geek to Geek we will have an array, where each element of the array will be a LinkedList.
    // [LL, LL, LL] => That's smart!

    Graph(final int v) {
        this.V = v;
        adjacent = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacent[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int vertexEnd) {
        this.adjacent[vertex].add(vertexEnd);// For DIRECTED GRAPH!
//        this.adjacent[vertexEnd].add(vertex);// for undirected
    }

    public void BFS(final int vertexSource) {
        // As you know graph are different from trees, we might find infinite buckle
        // so we need a TreeSet, in order to avoid revisiting a vertex
        // it is quite similar to sptSet of Dijkstra

        // As theory says, the key concept to do this BFS is a queue, so let's do it
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertexSource] = true;
        queue.add(vertexSource);

//        Integer currentVertex;
        // Let's iterate the queue till it's empty
//        while (!queue.isEmpty()) {
//            currentVertex = queue.pop();
//            System.out.println(currentVertex + "");
//            // let's iterate all the adjacent vertices to pop in on our famous queue
//            for (int index = 0; index < this.adjacent[currentVertex].size(); index++) { // Not using the smart way to iterate a LinkedList
//                if (!visited[this.adjacent[currentVertex].get(index)]) { // since it's a graph, we avoid a possible infinite buckle
//                    queue.add(this.adjacent[currentVertex].get(index));
//                    visited[this.adjacent[currentVertex].get(index)] = true;
//                }
//            }
//        }
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


    // Resolving HackerRank problem using the before BFS algorithm
    public void BFSHackerRank(final int vertexSource) {
        boolean visited[] = new boolean[V]; // this is to avoid infinite buckle on a graph
        int weightTravel[] = new int[V]; // important to see how much does it takes to reach another vertex from `vertexSource`

        // -1 represent that we can't reach that node :(, and at the beginning sound good,right?
        Arrays.fill(weightTravel, -1);

        // As theory says, the key concept to do this BFS is a queue, so let's do it
        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertexSource] = true;
        weightTravel[vertexSource] = 0;// This is key, because you can reach the same vertex by NO MOVING at all
        queue.add(vertexSource);

        Integer current;
        while (!queue.isEmpty()) {
            current = queue.pop();

            // let's iterate all the adjacent vertices to pop in on our famous queue
            for (final Integer vertix : this.adjacent[current]) {
                if (!visited[vertix]) { // important to avoid unnecessary cycles
                    visited[vertix] = true;
                    queue.add(vertix);
                    weightTravel[vertix] = weightTravel[current] + 6;// we add 6, because it's the default value for adjacent according to the problem
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


class SolutionReadingQueries {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt(); // number of queries.
        for (int i = 0; i < queries; i++) {
            int n = scanner.nextInt();
            Graph graph = new Graph(n);

            int m = scanner.nextInt();
            for (int edge = 0; edge < m; edge++) {
                int origin = scanner.nextInt() - 1;
                int end = scanner.nextInt() - 1;
                graph.addEdge(origin, end);
            }
            int source = scanner.nextInt() - 1;
            graph.BFSHackerRank(source);
        }
    }

    public static void squeleton(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt(); // number of queries.
        System.out.println("queries: " + queries);
        for (int i = 0; i < queries; i++) {
            int n = scanner.nextInt();
            System.out.println("nodes: " + n);
            int m = scanner.nextInt();
            System.out.println("adjacent: " + m);
            for (int edge = 0; edge < m; edge++) {
                int origin = scanner.nextInt() - 1;
                int end = scanner.nextInt() - 1;
                System.out.println("edge: " + origin + " to " + end);
            }
            int source = scanner.nextInt() - 1;
            System.out.println("source: " + source);
        }


    }
}
