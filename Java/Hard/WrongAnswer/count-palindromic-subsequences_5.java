class Solution {
    public int countPalindromes(String s) {
        
        int n = s.length();
        int mod = 1000000007;
        int[][][] dp = new int[n][n][10];
        for (int i = 0; i < n; i++) {
            dp[i][i][s.charAt(i) - '0'] = 1;
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                for (int k = 0; k < 10; k++) {
                    dp[i][j][k] = dp[i][j - 1][k] + dp[i + 1][j][k] - dp[i + 1][j - 1][k];
                    if (s.charAt(i) - '0' == k) {
                        dp[i][j][k]++;
                    }
                    if (s.charAt(j) - '0' == k) {
                        dp[i][j][k]++;
                    }
                    dp[i][j][k] = Math.max(0, dp[i][j][k]);
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 10; k++) {
            ans = (ans + dp[0][n - 1][k]) % mod;
        }
        return ans;
    }
}