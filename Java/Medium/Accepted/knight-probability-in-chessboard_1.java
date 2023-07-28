class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        double[][][] dp = new double[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return knightProbability(n, k, row, column, dp);
    }
    public double knightProbability(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[row][column][k] != -1) {
            return dp[row][column][k];
        }
        double p = 0;
        p += knightProbability(n, k-1, row-1, column-2, dp);
        p += knightProbability(n, k-1, row-1, column+2, dp);
        p += knightProbability(n, k-1, row+1, column-2, dp);
        p += knightProbability(n, k-1, row+1, column+2, dp);
        p += knightProbability(n, k-1, row-2, column-1, dp);
        p += knightProbability(n, k-1, row-2, column+1, dp);
        p += knightProbability(n, k-1, row+2, column-1, dp);
        p += knightProbability(n, k-1, row+2, column+1, dp);
        dp[row][column][k] = p * 0.125;
        return dp[row][column][k];
    }
}