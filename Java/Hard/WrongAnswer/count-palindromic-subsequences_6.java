class Solution {
    public int countPalindromes(String s) {
        
        int n = s.length();
        int mod = 1000000007;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = 1;
            dp[i][i][1] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1][0] = 2;
            dp[i][i + 1][1] = s.charAt(i) == s.charAt(i + 1) ? 3 : 2;
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j][0] = (dp[i + 1][j][0] + dp[i][j - 1][0] - dp[i + 1][j - 1][0]) % mod;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j][1] = (dp[i + 1][j - 1][1] + dp[i][j][0] + 1) % mod;
                } else {
                    dp[i][j][1] = (dp[i + 1][j - 1][1] + dp[i][j][0]) % mod;
                }
            }
        }
        return (dp[0][n - 1][1] + mod) % mod;
    }
}