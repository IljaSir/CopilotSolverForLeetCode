class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;
        long[] prefix = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = weights[i];
            } else {
                prefix[i] = prefix[i - 1] + weights[i];
            }
        }
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <= n; i++) {
            dp[i][1] = prefix[i - 1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j - 1], prefix[i - 1] - prefix[l - 1]));
                }
            }
        }
        return dp[n][k];
    }
}