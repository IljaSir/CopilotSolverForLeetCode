class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = points[i][j];
                } else {
                    long max = 0;
                    for (int k = 0; k < n; k++) {
                        max = Math.max(max, dp[i - 1][k] - Math.abs(k - j));
                    }
                    dp[i][j] = max + points[i][j];
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