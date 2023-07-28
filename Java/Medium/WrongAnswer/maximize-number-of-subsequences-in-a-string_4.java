class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        long[][] dp = new long[text.length() + 1][3];
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < 3; j++) {
                dp[i + 1][j] = dp[i][j];
            }
            if (text.charAt(i) == pattern.charAt(0)) {
                dp[i + 1][1] += dp[i][0] + 1;
            }
            if (text.charAt(i) == pattern.charAt(1)) {
                dp[i + 1][2] += dp[i][1];
            }
        }
        return dp[text.length()][2];
    }
}