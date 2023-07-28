class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = points[i][j];
                if (i > 0) {
                    dp[i][j] += Math.max(dp[i - 1][j], Math.max(j > 0 ? dp[i - 1][j - 1] : Long.MIN_VALUE, j < n - 1 ? dp[i - 1][j + 1] : Long.MIN_VALUE));
                }
            }
        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[m - 1][j]);
        }
        return ans;
    }
}