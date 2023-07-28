class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        
        int MOD = 1000000007;
        long[][] dp = new long[k + 1][endPos - startPos + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < endPos - startPos + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j < endPos - startPos) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[k][0];
    }
}