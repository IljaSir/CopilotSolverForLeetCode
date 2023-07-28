class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int m = n / 3;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 2] + slices[j - 1]);
            }
        }
        int res = dp[m][n - 1];
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 2] + slices[j - 1]);
            }
        }
        return Math.max(res, dp[m][n]);
    }
}