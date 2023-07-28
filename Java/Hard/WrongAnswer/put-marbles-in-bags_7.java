class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;
        long[] prefix = new long[n];
        prefix[0] = weights[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + weights[i];
        }
        long[][] dp = new long[n][k + 1];
        for(int i = 0; i < n; i++) {
            dp[i][1] = prefix[i];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 2; j <= k; j++) {
                dp[i][j] = Long.MAX_VALUE;
                for(int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j - 1], prefix[i] - prefix[l]));
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i][k]);
        }
        return ans;
    }
}