class Solution {
    public int countPalindromicSubsequences(String s) {
        
        int n = s.length();
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            dp[i][i][s.charAt(i) - 'a'] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    if (s.charAt(i) == s.charAt(j) && s.charAt(i) - 'a' == k) {
                        dp[i][j][k] = dp[i + 1][j - 1][k] * 2;
                        for (int l = 0; l < 4; l++) {
                            dp[i][j][k] += dp[i + 1][j - 1][l];
                            dp[i][j][k] %= (1e9 + 7);
                        }
                    } else {
                        dp[i][j][k] = dp[i + 1][j][k] + dp[i][j - 1][k] - dp[i + 1][j - 1][k];
                        dp[i][j][k] %= (1e9 + 7);
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            ans += dp[0][n - 1][k];
            ans %= (1e9 + 7);
        }
        return ans;
    }
}