class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            graph[u][v] = graph[v][u] = 1;
            degree[u]++;
            degree[v]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 0) continue;
                for (int k = j + 1; k < n; k++) {
                    if (graph[i][k] == 0 || graph[j][k] == 0) continue;
                    res = Math.min(res, degree[i] + degree[j] + degree[k] - 6);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}