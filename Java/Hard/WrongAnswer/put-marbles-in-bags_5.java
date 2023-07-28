class Solution {
    public long putMarbles(int[] weights, int k) {
        
        long[] prefixSum = new long[weights.length];
        prefixSum[0] = weights[0];
        for (int i = 1; i < weights.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + weights[i];
        }
        long[][] dp = new long[k + 1][weights.length + 1];
        for (int i = 1; i <= k; ++i) {
            for (int j = i; j <= weights.length; ++j) {
                dp[i][j] = Long.MAX_VALUE;
                for (int p = i - 1; p < j; ++p) {
                    long cost = p == 0 ? 0 : (prefixSum[j - 1] - prefixSum[p - 1]) * (j - p);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][p] + cost);
                }
            }
        }
        return dp[k][weights.length];
    }
}