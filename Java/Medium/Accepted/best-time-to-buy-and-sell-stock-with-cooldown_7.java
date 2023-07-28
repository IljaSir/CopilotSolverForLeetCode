class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], (i - 2 < 0 ? 0 : sell[i - 2]) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[len - 1];
    }
}