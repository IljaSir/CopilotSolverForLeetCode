class Solution {
    public int longestPalindrome(String word1, String word2) {
        
        String s = word1 + word2;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(n - j - 1)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i][n - i - 1] > 0) {
                res = Math.max(res, dp[i][n - i - 1] * 2 + (i < word1.length() && n - i - 1 < word1.length() ? 1 : 0));
            }
        }
        return res;
    }
}