class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        int[] count = new int[2];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                count[0]++;
            } else if (text.charAt(i) == pattern.charAt(1)) {
                count[1]++;
            }
        }
        long[] dp = new long[text.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                dp[i + 1] += dp[i];
            } else if (text.charAt(i) == pattern.charAt(1)) {
                dp[i + 1] += dp[i];
                dp[i + 1] += dp[i + 1 - count[0] - count[1]];
            }
        }
        return dp[text.length()];
    }
}