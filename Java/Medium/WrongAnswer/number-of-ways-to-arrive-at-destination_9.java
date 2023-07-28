class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int mod = 1000000007;
        long[][] dp = new long[n][n];
        for (long[] r : dp) {
            Arrays.fill(r, Long.MAX_VALUE);
        }
        for (int[] r : roads) {
            dp[r[0]][r[1]] = Math.min(dp[r[0]][r[1]], r[2]);
            dp[r[1]][r[0]] = Math.min(dp[r[1]][r[0]], r[2]);
        }
        for (int i = 0; i < n; i++) dp[i][i] = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] < Long.MAX_VALUE && dp[k][j] < Long.MAX_VALUE && dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        long[][] ways = new long[n][n];
        ways[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[0][j] == dp[0][i] + dp[i][j]) {
                    ways[0][j] += ways[0][i];
                    ways[0][j] %= mod;
                }
            }
        }
        return (int)ways[0][n - 1];
    }
}