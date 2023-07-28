class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long result = 0;
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] + 1) {
                count++;
            } else {
                count = 0;
            }
            result += count;
        }
        return result;
    }
}