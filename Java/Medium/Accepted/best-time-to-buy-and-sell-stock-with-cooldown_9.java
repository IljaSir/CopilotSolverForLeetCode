class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int profit = prices[i] - prices[j];
                if (j >= 2) {
                    profit += dp[j - 2];
                }
                max = Math.max(max, profit);
            }
            dp[i] = Math.max(dp[i - 1], max);
        }
        return dp[len - 1];
    }
}