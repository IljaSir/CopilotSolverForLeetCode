class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        int[][][] dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m <= k; m++) {
                    dp[i][j][m] = -1;
                }
            }
        }
        return 1.0 * dfs(n, k, row, column, dp) / Math.pow(8, k);
    }

    public int dfs(int n, int k, int row, int column, int[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[row][column][k] != -1) {
            return dp[row][column][k];
        }
        dp[row][column][k] = dfs(n, k - 1, row - 2, column - 1, dp) + dfs(n, k - 1, row - 2, column + 1, dp) + dfs(n, k - 1, row - 1, column - 2, dp) + dfs(n, k - 1, row - 1, column + 2, dp) + dfs(n, k - 1, row + 1, column - 2, dp) + dfs(n, k - 1, row + 1, column + 2, dp) + dfs(n, k - 1, row + 2, column - 1, dp) + dfs(n, k - 1, row + 2, column + 1, dp);
        return dp[row][column][k];
    }
}