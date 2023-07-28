class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        
        int n = basket1.length;
        long[][] dp = new long[n+1][3];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]));
            if (basket1[i-1] == basket2[i-1]) {
                dp[i][1] = dp[i-1][1] + basket1[i-1];
                dp[i][2] = dp[i-1][2] + basket1[i-1];
            } else {
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + basket1[i-1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + basket2[i-1];
            }
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}