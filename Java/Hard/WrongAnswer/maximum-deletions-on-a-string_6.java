class Solution {
    public int deleteString(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = Math.max(dp[j][j + i], dp[j + 1][j + i - 1] + 2);
                }
            }
        }
        return dp[0][n - 1];
    }
}