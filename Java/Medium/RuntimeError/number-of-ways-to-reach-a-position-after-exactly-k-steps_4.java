class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        
        int mod = (int)1e9 + 7;
        int[][] dp = new int[k + 1][endPos + 1];
        dp[0][startPos] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= endPos; j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
            }
        }
        return dp[k][endPos];
    }
}