class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        long[] dp = new long[n];
        dp[0] = costs[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + costs[i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long cur = 0;
            int left = k - 1;
            int start = i;
            while (left > 0) {
                int end = Math.min(start + candidates - 1, n - 1);
                cur += dp[end] - (start > 0 ? dp[start - 1] : 0);
                start = end + 1;
                left--;
            }
            if (start < n) {
                cur += dp[n - 1] - (start > 0 ? dp[start - 1] : 0);
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}