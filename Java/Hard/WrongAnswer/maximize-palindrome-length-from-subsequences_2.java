class Solution {
    public int longestPalindrome(String word1, String word2) {
        
        String s = word1 + word2;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] == j - i + 1 && (i < word1.length() ^ j >= word1.length())) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}