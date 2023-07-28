class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        for (int t = 1; t <= maxTime; t++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (t >= w && dp[u][t - w] != Integer.MAX_VALUE) {
                    dp[v][t] = Math.min(dp[v][t], dp[u][t - w] + passingFees[v]);
                }
                if (t >= w && dp[v][t - w] != Integer.MAX_VALUE) {
                    dp[u][t] = Math.min(dp[u][t], dp[v][t - w] + passingFees[u]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int t = 1; t <= maxTime; t++) {
            ans = Math.min(ans, dp[n - 1][t]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}