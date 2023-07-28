class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long periods = 0;
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                count++;
            } else {
                periods += (count * (count + 1)) / 2;
                count = 0;
            }
        }
        periods += (count * (count + 1)) / 2;
        return periods;
    }
}