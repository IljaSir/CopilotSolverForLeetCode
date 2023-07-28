class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        char[] str = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (str[j] == str[i + j]) {
                    dp[j][i + j] = dp[j + 1][i + j - 1] + 2;
                } else {
                    dp[j][i + j] = Math.max(dp[j + 1][i + j], dp[j][i + j - 1]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[0][i] + dp[i + 1][j - 1] + dp[j][n - 1] > res) {
                    res = dp[0][i] + dp[i + 1][j - 1] + dp[j][n - 1];
                }
            }
        }
        return res;
    }
}