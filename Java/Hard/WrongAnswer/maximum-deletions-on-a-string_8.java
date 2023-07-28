class Solution {
    public int deleteString(String s) {
        
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int[][] dp = new int[n][n];
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                for (int t = i + 1; t <= j; t++) {
                    if (s.charAt(i) == s.charAt(t)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][t - 1] + dp[t][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}