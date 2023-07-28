class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE);
        }
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        for (int i = 1; i <= maxTime; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (g[j][k] != Integer.MAX_VALUE && dp[k][i - g[j][k]] != Integer.MAX_VALUE) {
                        dp[j][i] = Math.min(dp[j][i], dp[k][i - g[j][k]] + passingFees[j]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= maxTime; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}