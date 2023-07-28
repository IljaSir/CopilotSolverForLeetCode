class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long periods = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && prices[j] == prices[j - 1] - 1) {
                j++;
            }
            periods += (j - i) * (j - i - 1) / 2;
            i = j - 1;
        }
        return periods;
    }
}