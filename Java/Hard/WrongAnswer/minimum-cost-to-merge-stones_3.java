class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        int[][][] dp = new int[n][n][k + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < n; ++i) {
            dp[i][i][1] = 0;
        }
        for (int m = 2; m <= n; ++m) {
            for (int i = 0; i <= n - m; ++i) {
                int j = i + m - 1;
                for (int p = 2; p <= k; ++p) {
                    for (int mid = i; mid < j; mid += k - 1) {
                        dp[i][j][p] = Math.min(dp[i][j][p], dp[i][mid][p - 1] + dp[mid + 1][j][1]);
                    }
                }
                dp[i][j][1] = dp[i][j][k] + prefix[j + 1] - prefix[i];
            }
        }
        return dp[0][n - 1][1];
    }
}