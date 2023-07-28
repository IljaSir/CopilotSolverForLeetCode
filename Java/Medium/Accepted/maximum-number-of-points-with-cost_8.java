class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = dp[(i - 1) % 2][0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1] - 1, dp[(i - 1) % 2][j]);
            }
            right[n - 1] = dp[(i - 1) % 2][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, dp[(i - 1) % 2][j]);
            }
            for (int j = 0; j < n; j++) {
                dp[i % 2][j] = Math.max(left[j], right[j]) + points[i][j];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[(m - 1) % 2][i]);
        }
        return ans;
    }
}