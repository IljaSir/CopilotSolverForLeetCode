class Solution {
    public int countHousePlacements(int n) {
        
        if (n == 1) {
            return 4;
        }
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 4;
        dp[2] = 9;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return (int)dp[n];
    }
}