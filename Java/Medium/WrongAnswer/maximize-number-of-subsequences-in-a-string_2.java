class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        int n = text.length();
        int m = pattern.length();
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char tc = text.charAt(i);
                char pc = pattern.charAt(j);
                if (tc == pc) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[n][m];
    }
}