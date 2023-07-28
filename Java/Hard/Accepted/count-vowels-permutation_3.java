class Solution {
    public int countVowelPermutation(int n) {
        
        int mod = (int) 1e9 + 7;
        long[][] dp = new long[n][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        long res = 0;
        for (int i = 0; i < 5; i++) {
            res = (res + dp[n - 1][i]) % mod;
        }
        return (int) res;
    }
}