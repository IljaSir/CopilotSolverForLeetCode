class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long count = 0;
        int n = prices.length;
        int[] dp = new int[n];
        for (int i=1;i<n;i++) {
            if (prices[i] == prices[i-1] + 1) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 0;
            }
            count += dp[i];
        }
        return count;
    }
}