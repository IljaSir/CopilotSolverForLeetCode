class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        if (n == 0) return 0;
        if (k > n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int min = prices[0];
            for (int j = 1; j < n; j++) {
                min = Math.min(min, prices[j] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
            }
        }
        return dp[k][n - 1];
    }
}