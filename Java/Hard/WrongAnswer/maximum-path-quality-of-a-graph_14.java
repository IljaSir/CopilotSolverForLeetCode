class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        int[][] g = new int[n][n];
        for (int[] e : g) {
            Arrays.fill(e, -1);
        }
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        int[] dp = new int[n];
        dp[0] = values[0];
        int res = dp[0];
        for (int i = 0; i < maxTime; i++) {
            int[] ndp = new int[n];
            for (int j = 0; j < n; j++) {
                ndp[j] = dp[j];
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (g[j][k] != -1) {
                        ndp[k] = Math.max(ndp[k], dp[j] + values[k]);
                    }
                }
            }
            dp = ndp;
            res = Math.max(res, dp[0]);
        }
        return res;
    }
}