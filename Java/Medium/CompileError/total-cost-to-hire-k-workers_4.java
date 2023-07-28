class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        long[][] dp = new long[k + 1][n + 1];
        int n = costs.length;
        long[] dp = new long[k + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            long[] next = new long[k + 1];
            Arrays.fill(next, Long.MAX_VALUE);
            for (int j = 0; j <= i; j++) {
                long min = Long.MAX_VALUE;
                for (int t = Math.max(0, j - candidates); t < Math.min(i, j + candidates); t++) {
                    min = Math.min(min, dp[t]);
                }
                next[j] = min + costs[i - 1];
            }
            dp = next;
        }
        long ans = Long.MAX_VALUE;
        for (int i = k - candidates; i <= k; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}