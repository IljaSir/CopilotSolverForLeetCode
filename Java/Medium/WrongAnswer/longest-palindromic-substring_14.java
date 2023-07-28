class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    dp[j] = 1;
                } else if (i + 1 == j) {
                    dp[j] = s.charAt(i) == s.charAt(j) ? 2 : 0;
                } else if (i + 1 < j) {
                    dp[j] = s.charAt(i) == s.charAt(j) && dp[j - 1] > 0 ? dp[j - 1] + 2 : 0;
                }
                if (dp[j] > max) {
                    max = dp[j];
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}