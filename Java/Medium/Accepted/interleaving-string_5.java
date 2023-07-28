class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return isInterleave(s2, s1, s3);
        }
        boolean[] dp = new boolean[s1.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i] = dp[i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0] = dp[0] && s2.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= s1.length(); j++) {
                dp[j] = (dp[j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[j] && s2.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()];
    }
}