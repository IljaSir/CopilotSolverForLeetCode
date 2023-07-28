class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        int n = text.length(), m = pattern.length();
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (text.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (text.charAt(i - 1) == pattern.charAt(0)) {
                res += dp[i - 1][m];
            }
        }
        return res;
    }
}