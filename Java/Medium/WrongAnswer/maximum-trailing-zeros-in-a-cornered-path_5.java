class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (val % 2 == 0) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                int cnt = 0;
                while (val % 2 == 0) {
                    cnt++;
                    val /= 2;
                }
                res = Math.max(res, Math.min(cnt, dp[i][j]));
            }
        }
        return res;
    }
}