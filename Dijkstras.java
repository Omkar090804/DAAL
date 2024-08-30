import java.util.*;

public class DijkstrasAlgorithm {

    // Method to perform Dijkstra's algorithm
    public static void dijkstra(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int curDist = current[1];

            if (curDist > dist[u]) continue;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] > 0) { // Edge exists
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new int[]{v, newDist});
                    }
                }
            }
        }

        printSolution(dist);
    }

    // Method to print the shortest distance from the source
    private static void printSolution(int[] dist) {
        System.out.println("Vertex \tDistance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        // Example graph as an adjacency matrix
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        // Run Dijkstra's algorithm from source vertex 0
        dijkstra(graph, 0);
    }
}
