class Solution {
    public int countHousePlacements(int n) {
        
        int mod = 1000000007;
        long[][] dp = new long[n+1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][0] * dp[i-1][1]) % mod;
        }
        return (int) ((dp[n][0] + dp[n][1]) % mod);
    }
}