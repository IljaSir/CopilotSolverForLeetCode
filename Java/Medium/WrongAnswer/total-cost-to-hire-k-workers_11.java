class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        long[] dp = new long[n];
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < candidates; ++i) {
            dp[i] = costs[i];
        }
        for (int i = 1; i < k; ++i) {
            long min = Long.MAX_VALUE;
            for (int j = i; j < n - k + i + 1; ++j) {
                min = Math.min(min, dp[j - 1]);
                dp[j] = min + costs[j];
            }
        }
        for (int i = n - k; i < n; ++i) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}