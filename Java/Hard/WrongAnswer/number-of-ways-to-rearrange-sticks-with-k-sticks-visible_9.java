class Solution {
    public int rearrangeSticks(int n, int k) {
        
        // dp[i][j] = number of ways to arrange i sticks such that there are j sticks visible
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] * (i-1)
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] * (i-1)
        // dp[i][j] = dp[i][j-1] + dp[i-1][j] * i
        int MOD = 1000000007;
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i][j-1] + (int)(((long)dp[i-1][j] * i) % MOD)) % MOD;
            }
        }
        return dp[n][k];
    }
}