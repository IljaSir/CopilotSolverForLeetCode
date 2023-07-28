class Solution {
    public int deleteString(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                } else {
                    dp[j][j + i] = Math.min(dp[j + 1][j + i], dp[j][j + i - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}