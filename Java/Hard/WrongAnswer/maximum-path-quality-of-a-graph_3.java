class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        int[][] g = new int[n][n];
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            g[u][v] = g[v][u] = t;
        }
        int[] dp = new int[n];
        dp[0] = values[0];
        int ans = values[0];
        for (int k = 1; k <= maxTime; k++) {
            int[] ndp = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] > 0 && g[i][j] <= k) {
                        ndp[j] = Math.max(ndp[j], dp[i] + values[j]);
                    }
                }
            }
            dp = ndp;
            ans = Math.max(ans, dp[0]);
        }
        return ans;
    }
}