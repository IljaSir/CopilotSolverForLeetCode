class Solution {
    public int countPalindromes(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        int mod = (int)1e9 + 7;
        for (int len = 1; len <= 5; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = 1;
                } else if (len == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
                    } else {
                        dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + mod) % mod;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}