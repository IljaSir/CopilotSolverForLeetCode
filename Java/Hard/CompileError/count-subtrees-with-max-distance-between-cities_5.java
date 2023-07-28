class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] result = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            int[] temp = countSubgraphsForEachDiameter(n, edges, i);
            for (int j = 0; j < n - 1; j++) {
                result[j] += temp[j];
            }
        }
        return result;
    }
    
    private int[] countSubgraphsForEachDiameter(int n, int[][] edges, int mask) {
        int[] result = new int[n - 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) > 0) {
                count++;
            }
        }
        if (count < 2) {
            return result;
        }
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            if (((1 << u) & mask) > 0 && ((1 << v) & mask) > 0) {
                graph[u][v] = 1;
                graph[v][u] = 1;
            }
        }
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
            distance[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) > 0) {
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & mask) > 0) {
                        if (graph[i][j] > 0) {
                            distance[i][j] = 1;
                        }
                    }
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE &&
    }
}