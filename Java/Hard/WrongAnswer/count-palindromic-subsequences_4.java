class Solution {
    public int countPalindromes(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }
        return dp[0][n - 1];
    }
}