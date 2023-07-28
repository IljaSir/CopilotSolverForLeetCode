class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0x7fffffff);
        }
        dp[0][0] = passingFees[0];
        for (int i = 1; i < n; i++) {
            dp[i][i] = passingFees[i];
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dp[u][v] = Math.min(dp[u][v], passingFees[v]);
            dp[v][u] = Math.min(dp[v][u], passingFees[u]);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int ans = 0x7fffffff;
        for (int i = 0; i < n; i++) {
            if (dp[0][i] + dp[i][n - 1] <= maxTime) {
                ans = Math.min(ans, dp[0][i] + passingFees[n - 1]);
            }
        }
        return ans == 0x7fffffff ? -1 : ans;
    }
}