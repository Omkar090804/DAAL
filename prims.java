import java.util.*;

public class PrimsAlgorithm {

    public static void primsAlgorithm(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] inMST = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, key[0]});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];

            if (inMST[u]) continue;
            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                    pq.add(new int[]{v, key[v]});
                }
            }
        }

        printMST(parent, graph);
    }

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
