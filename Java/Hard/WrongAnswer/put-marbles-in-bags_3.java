class Solution {
    public long putMarbles(int[] weights, int k) {
        
        long[] prefixSum = new long[weights.length];
        prefixSum[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + weights[i];
        }
        
        long[] dp = new long[weights.length];
        dp[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            dp[i] = dp[i - 1] + weights[i] * i;
        }
        
        for (int i = 1; i < k; i++) {
            for (int j = weights.length - 1; j >= i; j--) {
                dp[j] = Long.MAX_VALUE;
                for (int l = i - 1; l < j; l++) {
                    dp[j] = Math.min(dp[j], dp[l] + (prefixSum[j] - prefixSum[l]) * (j - l));
                }
            }
        }
        
        return dp[weights.length - 1];
    }
}