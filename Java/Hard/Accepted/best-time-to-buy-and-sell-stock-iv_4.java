class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        if (n <= 1) return 0;
        if (k > n / 2) {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}