class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] + 1) {
                res += i;
            }
        }
        return res;
    }
}