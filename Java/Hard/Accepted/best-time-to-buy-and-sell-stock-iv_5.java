class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        if (n == 0) return 0;
        if (k >= n/2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1]) {
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }
        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i-1][j-1] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
}