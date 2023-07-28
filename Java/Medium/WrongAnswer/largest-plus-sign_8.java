class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] dp = new int[n][n];
        int[][] grid = new int[n][n];
        for (int[] row : grid)
            Arrays.fill(row, 1);
        for (int[] mine : mines)
            grid[mine[0]][mine[1]] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, l = 0, r = 0, u = 0, d = 0; j < n; j++) {
                l = grid[i][j] == 0 ? 0 : l + 1;
                dp[i][j] = l;
                r = grid[i][n - 1 - j] == 0 ? 0 : r + 1;
                dp[i][n - 1 - j] = Math.min(dp[i][n - 1 - j], r);
                u = grid[j][i] == 0 ? 0 : u + 1;
                dp[j][i] = Math.min(dp[j][i], u);
                d = grid[n - 1 - j][i] == 0 ? 0 : d + 1;
                dp[n - 1 - j][i] = Math.min(dp[n - 1 - j][i], d);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res = Math.max(res, dp[i][j]);
        return res;
    }
}