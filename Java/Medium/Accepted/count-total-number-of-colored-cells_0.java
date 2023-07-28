class Solution {
    public long coloredCells(int n) {
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * 4;
        }
        return dp[n];
    }
}