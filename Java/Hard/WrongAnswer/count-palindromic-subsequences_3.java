class Solution {
    public int countPalindromes(String s) {
        
        int n = s.length();
        int mod = 1000000007;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) dp[i][i + 1] = 3;
            else dp[i][i + 1] = 2;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
                else dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + mod) % mod;
            }
        }
        return dp[0][n - 1];
    }
}