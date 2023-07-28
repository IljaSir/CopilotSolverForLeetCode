class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            for (int j : graph[i]) {
                dist[i][j] = 1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }
        for (int mask = 1; mask < 1 << n; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    for (int j = 0; j < n; j++) {
                        if ((mask & (1 << j)) > 0 && i != j) {
                            dp[mask][i] = Math.min(dp[mask][i], dp[mask ^ (1 << i)][j] + dist[j][i]);
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[(1 << n) - 1][i]);
        }
        return ans;
    }
}