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
    // So, we are going to set the top of the arrays, being the number of vertex.
    private static final int V = 9;
    /**
     * Dijkstra's single source shortest path
     * @param graph, the graph is represented using adjacency matrix representation
     * @param source
     */
    public void dijkstra(int graph[][], int source) {
        int distances[] = new int[V];// Represents the distance of all of them.
        Boolean sptSet[] = new Boolean[V];// Shortest path tree set

        // We initialize the distance of the vertex to INFINITE, and the tree set to false
        for (int i = 0; i < V; i++) {
            distances[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Since we have source, it's distance will be set to 0
        distances[source] = 0;

        // Let's find out the shortest path for all vertex
        for (int index = 0; index < V-1; index++) {
            // Pick a vertex u which is not there in sptSet and has minimum distance value.
            int vertexCandidate = minimumDistance(distances, sptSet);
            sptSet[vertexCandidate] = true;
            // Update distance value of all adjacent vertices of u.
            // A bit problematic, i know, but we need to walk to all the adjacent vertices.
            for (int adjacentVertex = 0; adjacentVertex < V; adjacentVertex++) {
                // The graph is a MATRIX!
                if (!sptSet[adjacentVertex] && // we don't update the vertex that are already on the tree set
                        distances[vertexCandidate] != Integer.MAX_VALUE && // we do this because, we are iterating all the vertex, and some distances are not updated
                        graph[vertexCandidate][adjacentVertex] != 0 && // to validate if there is an edge between the candidate and the supposed adjacent vertex
                        distances[vertexCandidate] + graph[vertexCandidate][adjacentVertex] <= distances[adjacentVertex] // if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
                        ) {
                    distances[adjacentVertex] = distances[vertexCandidate] + graph[vertexCandidate][adjacentVertex];
                }
            }

        }

        // let's print the minimal distance to reach each vertices from source
        for (int i = 0; i < V; i++) {
            System.out.println(String.format("From %s source to %s vertex, the minimum distance is %d", source, i, distances[i]));
        }

    }

    public int minimumDistance(int distances[], Boolean sptSet[]) {
        int minimumIndex = -1;
        int minimum = Integer.MAX_VALUE;
        for (int vertex = 0; vertex < V; vertex++) {
            if (!sptSet[vertex] && distances[vertex] < minimum) {
                minimum = distances[vertex];
                minimumIndex = vertex;
            }
        }
        return minimumIndex;
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
