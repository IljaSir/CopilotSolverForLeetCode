class Solution {
    public boolean checkPartitioning(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                dp[i][i + len] = dp[i + 1][i + len - 1] && (s.charAt(i) == s.charAt(i + len));
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (dp[0][i]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (dp[i + 1][j] && dp[j + 1][n - 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}