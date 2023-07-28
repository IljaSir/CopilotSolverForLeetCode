class Solution {
    public int deleteString(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                dp[i][j] = 1 + dp[i + 1][j];
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}