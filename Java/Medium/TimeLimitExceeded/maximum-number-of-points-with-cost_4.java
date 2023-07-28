class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = points[i][j];
                if (i > 0) {
                    long max = dp[i - 1][j];
                    for (int k = j - 1; k >= 0; k--) {
                        max = Math.max(max, dp[i - 1][k] - (j - k));
                    }
                    for (int k = j + 1; k < n; k++) {
                        max = Math.max(max, dp[i - 1][k] - (k - j));
                    }
                    dp[i][j] += max;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[m - 1][i]);
        }
        return res;
    }
}