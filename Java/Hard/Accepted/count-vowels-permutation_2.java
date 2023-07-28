class Solution {
    public int countVowelPermutation(int n) {
        
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % 1000000007;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 1000000007;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % 1000000007;
            dp[i][3] = (dp[i - 1][2]) % 1000000007;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000007;
        }

        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n][i]) % 1000000007;
        }
        return (int) ans;
    }
}