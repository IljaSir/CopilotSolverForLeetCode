class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + weights[i];
        }
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int l = i - 1; l < j; l++) {
                    long cost = sum[j] - sum[l];
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + cost * cost);
                }
            }
        }
        return dp[k][n];
    }
}