class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        int[][] g = new int[n][n];
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            g[u][v] = g[v][u] = t;
        }
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = values[0];
        for (int t = 0; t < maxTime; t++) {
            for (int u = 0; u < n; u++) {
                if (dp[u][t] < 0) {
                    continue;
                }
                for (int v = 0; v < n; v++) {
                    if (g[u][v] == 0) {
                        continue;
                    }
                    int nt = t + g[u][v];
                    if (nt > maxTime) {
                        continue;
                    }
                    dp[v][nt] = Math.max(dp[v][nt], dp[u][t] + values[v]);
                }
            }
        }
        int ans = 0;
        for (int t = 0; t <= maxTime; t++) {
            ans = Math.max(ans, dp[0][t]);
        }
        return ans;
    }
}