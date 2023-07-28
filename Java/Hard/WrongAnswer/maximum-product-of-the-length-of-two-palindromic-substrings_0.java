class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        long result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[0][i] && dp[j][n - 1]) {
                    result = Math.max(result, (long) (j - i - 1) * (i + 1));
                }
                if (dp[0][j] && dp[i][n - 1]) {
                    result = Math.max(result, (long) (i - j - 1) * (j + 1));
                }
            }
        }
        return result;
    }
}