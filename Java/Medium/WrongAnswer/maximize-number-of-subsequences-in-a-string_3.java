class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        int n = text.length();
        int m = pattern.length();
        long[][] dp = new long[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                dp[i][j] = dp[i+1][j];
                if (text.charAt(i) == pattern.charAt(j)) {
                    dp[i][j] += dp[i+1][j+1];
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                ans += dp[i+1][1];
            }
        }
        return ans;
    }
}