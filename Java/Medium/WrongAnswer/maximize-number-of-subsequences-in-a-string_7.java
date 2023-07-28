class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        long[][] dp = new long[text.length() + 1][3];
        for (int i = 0; i < text.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < text.length(); i++) {
            dp[i][1] = dp[i][0] * (text.charAt(i) == pattern.charAt(0) ? 1 : 0);
            dp[i][2] = dp[i][1] * (text.charAt(i) == pattern.charAt(1) ? 1 : 0);
            if (i > 0) {
                dp[i][1] += dp[i - 1][1];
                dp[i][2] += dp[i - 1][2];
            }
        }
        return dp[text.length() - 1][2];
    }
}