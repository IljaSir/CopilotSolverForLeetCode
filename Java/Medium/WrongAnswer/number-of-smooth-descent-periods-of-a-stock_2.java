class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long count = 0;
        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while (j < prices.length && prices[j] == prices[j - 1] - 1) {
                j++;
            }
            if (j > i + 1) {
                count += (long) (j - i) * (j - i - 1) / 2;
                i = j - 1;
            }
        }
        return count;
    }
}