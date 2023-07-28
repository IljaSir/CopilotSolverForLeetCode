class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        int[][] dp = new int[n][maxTime + 1];
        int res = 0;
        for (int t = 1; t <= maxTime; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > 0 && t >= graph[i][j]) {
                        dp[i][t] = Math.max(dp[i][t], dp[j][t - graph[i][j]] + values[i]);
                    }
                }
                res = Math.max(res, dp[i][t]);
            }
        }
        return res;
    }
}