class Solution {
    public int kInversePairs(int n, int k) {
        
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                int min = Math.max(0, j - i + 1);
                dp[i][j] = (dp[i][j-1] + dp[i-1][j] - dp[i-1][min-1]) % 1000000007;
            }
        }
        return (dp[n][k] + 1000000007) % 1000000007;
    }
}