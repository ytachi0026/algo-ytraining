package dev.ytachi.algorithms.graph;

/**
 * @author ytachi
 * Source: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 * Pseudo-code:
 * Algorithm
 * 1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree, i.e., whose minimum distance from source is calculated and finalized. Initially, this set is empty.
 * 2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE. Assign distance value as 0 for the source vertex so that it is picked first.
 * 3) While sptSet doesn’t include all vertices
 * ….a) Pick a vertex u which is not there in sptSet and has minimum distance value.
 * ….b) Include u to sptSet.
 * ….c) Update distance value of all adjacent vertices of u. To update the distance values, iterate through all adjacent vertices. For every adjacent vertex v, if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
 */
public class DijkstrasShortestPath {
    private static final int V = 9;

    public int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    /**
     * Dijkstra's single source shortest path
     * @param graph, the graph is represented using adjacency matrix representation
     * @param src
     */
    public void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        // Let's set all the vertex distance to infinite.
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        // Obviously the source vertex is set to 0.
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            // Let's find the minimum distance that are not on the stpSet
            int u = minDistance(dist, sptSet);

            //  Add this vertex to the sptSet
            sptSet[u] = true;

            // This is the tricky part, let's update all the vertex adjacent vertices using Dijktra logic
            // A bit problematic, i know, but we need to walk to all the adjacent vertices.
            for (int v = 0; v < V; v++) {
                // So, we don't update the minimum distance if the vertex is already on the sptPath
                if (!sptSet[v] &&
                        graph[u][v] != 0 && // this validation tell us if there is an edge between these two vertices
                        dist[u] != Integer.MAX_VALUE && // we ignore the vertices that are not yet updated (sorry)
                        dist[u] + graph[u][v] < dist[v]
                ) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }


        // let's print the minimal distance to reach each vertices from source
        for (int i = 0; i < V; i++) {
            System.out.println(String.format("From %s source to %s vertex, the minimum distance is %d", src, i, dist[i]));
        }

    }

    public static void main(String[] args) {
        // let's use the GeekForGeek matrix init
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        final DijkstrasShortestPath t = new DijkstrasShortestPath();
        t.dijkstra(graph, 0);
    }
}
