class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        int[][] dir = {{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
        double[][][] dp = new double[n][n][k+1];
        return helper(n, k, row, column, dir, dp);
    }
    
    public double helper(int n, int k, int row, int column, int[][] dir, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[row][column][k] != 0) {
            return dp[row][column][k];
        }
        double res = 0;
        for (int i = 0; i < dir.length; i++) {
            res += helper(n, k-1, row + dir[i][0], column + dir[i][1], dir, dp) * 0.125;
        }
        dp[row][column][k] = res;
        return res;
    }
}
    }
}