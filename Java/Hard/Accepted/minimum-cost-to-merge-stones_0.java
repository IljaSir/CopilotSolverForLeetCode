class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        int[][][] dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i][1] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int m = 2; m <= k; m++) {
                    for (int p = i; p < j; p += k - 1) {
                        dp[i][j][m] = Math.min(dp[i][j][m], dp[i][p][1] + dp[p + 1][j][m - 1]);
                    }
                }
                dp[i][j][1] = dp[i][j][k] + sum[j + 1] - sum[i];
            }
        }
        return dp[0][n - 1][1];
    }
}