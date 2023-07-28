class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] ans = new int[n - 1];
        int[] dp = new int[1 << n];
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            dist[u][v] = dist[v][u] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            int max = 0;
            for (int u = 0; u < n; u++) {
                for (int v = u + 1; v < n; v++) {
                    if (((i >> u) & 1) == 1 && ((i >> v) & 1) == 1) {
                        max = Math.max(max, dist[u][v]);
                    }
                }
            }
            if (max > 0) {
                dp[i] = dp[i - (i & -i)] + 1;
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (dp[j] > 0) {
                    ans[dp[j] + dp[i - j] - 2]++;
                }
            }
        }
        return ans;
    }
}