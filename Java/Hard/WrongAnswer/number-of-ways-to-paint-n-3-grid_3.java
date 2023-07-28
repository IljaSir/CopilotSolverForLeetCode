class Solution {
    public int numOfWays(int n) {
        
        long[][] dp = new long[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = 6;
        }
        for (int i = 1; i < n; i++) {
            dp[1][0] = dp[0][1] * 2 + dp[0][2] * 2;
            dp[1][1] = dp[0][0] * 2 + dp[0][2] * 2;
            dp[1][2] = dp[0][0] * 2 + dp[0][1] * 2;
            for (int j = 0; j < 3; j++) {
                dp[0][j] = dp[1][j] % 1000000007;
            }
        }
        return (int) ((dp[0][0] + dp[0][1] + dp[0][2]) % 1000000007);
    }
}