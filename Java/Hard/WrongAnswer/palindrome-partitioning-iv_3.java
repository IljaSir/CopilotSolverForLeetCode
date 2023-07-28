class Solution {
    public boolean checkPartitioning(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                dp[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1) && dp[i + 1][i + len - 2];
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}