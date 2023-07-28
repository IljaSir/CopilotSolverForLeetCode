class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        int dp[] = new int[n];
        int min = prices[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1], prices[i] - min - fee);
            min = Math.min(min, prices[i] - dp[i]);
        }
        return dp[n-1];
    }
}