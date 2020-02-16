package dev.ytachi.algorithms;

/**
 * Consider a directed graph whose vertices are numbered from 1 to n.
 * There is an edge from a vertex i to a vertex j iff either j = i + 1 or j = 3i.
 * The task is to find the minimum number of edges in a path in G from vertex 1 to vertex n.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 *
 * Each test case contains a value of n.
 *
 * Output:
 * Print the number of edges in the shortest path from 1 to n.
 *
 * Constraints:
 * 1<=T<=30
 * 1<=n <=1000
 *
 * Example:
 * Input:
 * 2
 * 9
 * 4
 *
 * Output:
 * 2
 * 2
 * @author ytachi
 */
public class ShortestPathFrom1Ton {
    private static final int V = 9;

    // This is copy, but useful minDistance function
    public int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // TIP: since the constraint says that DO NOT CONSIDER 0 on our vertex, we obey
    public int usingDijkstra(final int source, final int target){

        // Saving time to do the Dijkstra algorithm
        if (source == target) return 0; // These are the same, so there is no need to traverse and edge
        if (target == source + 1 || target == source * 3) {
            return 1; // It complies the rule set about the existence of an edge.
        }

        // we create the distances and the sptSet
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        // we initialize the arrays.
        for (int i = 1; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // we set 0, according to Dijkstra
        dist[source] = 0;

        for (int count = 1; count < V; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            if (u == target) {
                return dist[u]; // if we get the vertex u equals to target, so we are sure we got the minimum distance, which
                // is equal
            }
            // let's update the adjacent ones
            for (int v = 1; v < V; v++) {
                if (!sptSet[v] &&
                        (u + 1 == v || 3 * u == v) && // we make sure there is an edge to that vertex v
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + 1 < dist[v] // We only add 1, because it there is not rule that says the weight of an edge
                ) {
                    dist[v] = dist[u] + 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        final ShortestPathFrom1Ton test = new ShortestPathFrom1Ton();
        final int source =1, target = 4;
        final int edges = test.usingDijkstra(source, target);
        System.out.println(String.format("To get from vertex %s to vertex %s, we need to traverse %d edges", source, target, edges));
    }
}
