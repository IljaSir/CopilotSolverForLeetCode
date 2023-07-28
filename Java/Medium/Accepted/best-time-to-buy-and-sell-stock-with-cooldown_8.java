class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cool = new int[n];
        buy[0] = -prices[0];
        for(int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cool[i] = Math.max(cool[i - 1], sell[i - 1]);
        }
        return sell[n - 1];
    }
}