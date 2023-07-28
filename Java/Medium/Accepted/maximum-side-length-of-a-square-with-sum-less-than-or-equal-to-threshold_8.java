class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int lo = 0, hi = Math.min(m - i + 1, n - j + 1);
                while (lo < hi) {
                    int mid = (lo + hi + 1) >> 1;
                    int sum = dp[i + mid - 1][j + mid - 1] - dp[i - 1][j + mid - 1] - dp[i + mid - 1][j - 1] + dp[i - 1][j - 1];
                    if (sum > threshold) {
                        hi = mid - 1;
                    } else {
                        lo = mid;
                    }
                }
                ans = Math.max(ans, lo);
            }
        }
        return ans;
    }
}