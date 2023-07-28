class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + weights[i];
        }
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int p = i - 1; p < j; p++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][p] + prefix[j] - prefix[p]);
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dp[k][i]);
        }
        return res;
    }
}