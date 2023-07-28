class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        double[][][] dp = new double[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(n, k, row, column, dp);
    }
    
    private double dfs(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[row][column][k] != -1) {
            return dp[row][column][k];
        }
        double res = 0;
        res += dfs(n, k - 1, row - 1, column - 2, dp) * 0.125;
        res += dfs(n, k - 1, row - 2, column - 1, dp) * 0.125;
        res += dfs(n, k - 1, row - 2, column + 1, dp) * 0.125;
        res += dfs(n, k - 1, row - 1, column + 2, dp) * 0.125;
        res += dfs(n, k - 1, row + 1, column + 2, dp) * 0.125;
        res += dfs(n, k - 1, row + 2, column + 1, dp) * 0.125;
        res += dfs(n, k - 1, row + 2, column - 1, dp) * 0.125;
        res += dfs(n, k - 1, row + 1, column - 2, dp) * 0.125;
        dp[row][column][k] = res;
        return res;
    }
}