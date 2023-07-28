class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (i == 1 && j == 1) {
                    dp[i][j] = grid[i - 1][j - 1];
                } else if (i == 1) {
                    dp[i][j] = Math.max(dp[i][j], grid[i - 1][j - 1]);
                } else if (j == 1) {
                    dp[i][j] = Math.max(dp[i][j], grid[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], grid[i - 1][j - 1] + dp[i - 1][j - 1]);
                }
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int max = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if (query > grid[j - 1][k - 1]) {
                        max = Math.max(max, dp[j][k] + 1);
                    } else {
                        max = Math.max(max, dp[j][k]);
                    }
                }
            }
            result[i] = max;
        }
        return result;
    }
}