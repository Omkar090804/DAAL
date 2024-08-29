import java.util.*;
public class PrimsAlgorithm {
    static class Node implements Comparable<Node> {
        int vertex;
        int key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.key, other.key);
        }
    }
    public static void primsAlgorithm(int[][] graph) {
        int V = graph.length; // Number of vertices
        int[] parent = new int[V]; // Array to store the parent of each vertex
        int[] key = new int[V]; // Array to store the key value of each vertex
        boolean[] inMST = new boolean[V]; // Boolean array to check if a vertex is included in MST

        // Priority Queue to pick the minimum weight edge at each step
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Initialize the key values and parent array
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0; // Starting vertex has key value 0

        // Add the starting vertex to the priority queue
        pq.add(new Node(0, key[0]));

        while (!pq.isEmpty()) {
            // Extract the vertex with the minimum key value
            Node node = pq.poll();
            int u = node.vertex;

            // Skip if the vertex is already included in MST
            if (inMST[u]) continue;
            inMST[u] = true;

            // Update the key values of the adjacent vertices
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                    pq.add(new Node(v, key[v]));
                }
            }
        }
        
        printMST(parent, graph);
    }

    // Method to print the MST and its total weight
    private static void printMST(int[] parent, int[][] graph) {
        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++) {
            int weight = graph[i][parent[i]];
            System.out.println(parent[i] + " - " + i + " \t" + weight);
            totalWeight += weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        // Example graph represented by an adjacency matrix
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        primsAlgorithm(graph);
    }
}
