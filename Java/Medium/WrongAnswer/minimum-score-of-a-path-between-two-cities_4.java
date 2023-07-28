class Solution {
    public int minScore(int n, int[][] roads) {
        
        int m = roads.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = roads[i][0] - 1;
            int v = roads[i][1] - 1;
            int w = roads[i][2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
                    }
                }
            }
        }
        return dist[0][n - 1];
    }
}