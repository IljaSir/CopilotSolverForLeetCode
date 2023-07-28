class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + weights[i];
        }
        long[][] dp = new long[k][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = sum[i + 1];
        }
        for (int i = 1; i < k; i++) {
            for (int j = i; j < n; j++) {
                long min = Long.MAX_VALUE;
                for (int p = i - 1; p < j; p++) {
                    min = Math.min(min, Math.max(dp[i - 1][p], sum[j + 1] - sum[p + 1]));
                }
                dp[i][j] = min;
            }
        }
        return dp[k - 1][n - 1];
    }
}
    }
}