import java.util.*;

public class KruskalsAlgorithm {
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Union-Find with path compression and union by rank
    static class UnionFind {
        int[] parent, rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // Path compression
            }
            return parent[u];
        }

        void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }

    public static void kruskalsAlgorithm(int[][] graph) {
        int V = graph.length;
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Add all edges to the priority queue
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        UnionFind uf = new UnionFind(V);
        List<Edge> mst = new ArrayList<>();

        // Process edges in sorted order
        while (!edges.isEmpty() && mst.size() < V - 1) {
            Edge edge = edges.poll();
            int rootU = uf.find(edge.source);
            int rootV = uf.find(edge.destination);

            if (rootU != rootV) {
                uf.union(rootU, rootV);
                mst.add(edge);
            }
        }

        printMST(mst);
    }

    private static void printMST(List<Edge> mst) {
        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " \t" + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        kruskalsAlgorithm(graph);
    }
}
