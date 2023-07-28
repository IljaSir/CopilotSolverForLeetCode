class Solution {
    public int longestPalindrome(String word1, String word2) {
        
        String s = word1 + word2;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = word1.length(); j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans = Math.max(ans, dp[i + 1][j - 1] + 2);
                }
            }
        }
        return ans;
    }
}