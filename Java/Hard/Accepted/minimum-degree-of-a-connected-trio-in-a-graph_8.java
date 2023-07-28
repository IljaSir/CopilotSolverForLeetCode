class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[] degree = new int[n+1];
        boolean[][] connected = new boolean[n+1][n+1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            connected[u][v] = true;
            connected[v][u] = true;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                for (int k = j+1; k <= n; k++) {
                    if (connected[i][j] && connected[i][k] && connected[j][k]) {
                        res = Math.min(res, degree[i] + degree[j] + degree[k] - 6);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}