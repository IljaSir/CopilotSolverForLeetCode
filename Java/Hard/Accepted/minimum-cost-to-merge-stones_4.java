class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) {
            return -1;
        }
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int l = k; l <= n; ++l) {
            for (int i = 0; i + l <= n; ++i) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}