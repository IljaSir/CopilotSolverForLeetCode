class Solution {
    public int rearrangeSticks(int n, int k) {
        
        int mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (int)(((long)dp[i-1][j-1] + (long)(i-1) * dp[i-1][j]) % mod);
            }
        }
        return dp[n][k];
    }
}