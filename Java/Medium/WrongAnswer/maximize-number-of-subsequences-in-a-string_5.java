class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        int n = text.length();
        int m = pattern.length();
        long[][] dp = new long[n][m];
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                dp[i][0] = 1;
            }
            if (i > 0) {
                dp[i][0] += dp[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text.charAt(i) == pattern.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}