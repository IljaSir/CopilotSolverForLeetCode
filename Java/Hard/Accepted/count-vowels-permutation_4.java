class Solution {
    public int countVowelPermutation(int n) {
        
        int[][] dp = new int[n][5];
        int mod = 1000000007;
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = (int)(((long)dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod);
            dp[i][1] = (int)(((long)dp[i - 1][0] + dp[i - 1][2]) % mod);
            dp[i][2] = (int)(((long)dp[i - 1][1] + dp[i - 1][3]) % mod);
            dp[i][3] = (int)(dp[i - 1][2] % mod);
            dp[i][4] = (int)(((long)dp[i - 1][2] + dp[i - 1][3]) % mod);
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n - 1][i]) % mod;
        }
        return ans;
    }
}