class Solution {
    public int deleteString(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }
        return n - dp[0][n - 1];
    }
}