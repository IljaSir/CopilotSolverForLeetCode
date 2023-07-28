class Solution {
    public int rearrangeSticks(int n, int k) {
        
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (int)(((long)(i-1) * dp[i-1][j] + dp[i-1][j-1]) % 1000000007);
            }
        }
        return dp[n][k];
    }
}