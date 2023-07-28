class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, 0) + prices[i] - prices[i - 1];
            dp[i] = Math.max(dp[i - 1], max);
        }
        int right = 0;
        max = 0;
        for (int i = n - 1; i > 0; i--) {
            max = Math.max(max, 0) + prices[i] - prices[i - 1];
            right = Math.max(right, max);
            dp[i - 1] += right;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}