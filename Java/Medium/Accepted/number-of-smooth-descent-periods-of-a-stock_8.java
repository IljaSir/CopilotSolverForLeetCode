class Solution {
    public long getDescentPeriods(int[] prices) {
        
        int n = prices.length;
        long ans = n;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && prices[j] == prices[j - 1] - 1) {
                ++j;
            }
            if (j - i > 1) {
                ans += 1L * (j - i) * (j - i - 1) / 2;
            }
            i = j;
        }
        return ans;
    }
}