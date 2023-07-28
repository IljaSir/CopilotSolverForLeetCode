class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}