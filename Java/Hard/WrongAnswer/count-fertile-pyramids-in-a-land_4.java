class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (i > 0) {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                }
                if (j > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][0] + 1);
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][1] + 1);
                }
                if (i > 0 && j > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][0] + 1);
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j - 1][1] + 1);
                }
                res += dp[i][j][0] + dp[i][j][1] - 1;
            }
        }
        return res;
    }
}