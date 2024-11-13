public class Main {

    // Find the unvisited vertex with the smallest distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length;
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];

        // Initialize distances with infinity and visited vertices as false
        for (int i = 0; i < count; i++) {
            distance[i] = Integer.MAX_VALUE;
            visitedVertex[i] = false;
        }
        distance[source] = 0;

        // Main loop for Dijkstra's algorithm
        for (int i = 0; i < count - 1; i++) {
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            // Update distances of the adjacent vertices
            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        // Print shortest distances from the source to each vertex
        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
            { 0, 0, 1, 2, 0, 0, 0 },
            { 0, 0, 2, 0, 0, 3, 0 },
            { 1, 2, 0, 1, 3, 0, 0 },
            { 2, 0, 1, 0, 0, 0, 1 },
            { 0, 0, 3, 0, 0, 2, 0 },
            { 0, 3, 0, 0, 2, 0, 1 },
            { 0, 0, 0, 1, 0, 1, 0 }
        };

        Main dijkstra = new Main();
        dijkstra.dijkstra(graph, 0);
    }
}
