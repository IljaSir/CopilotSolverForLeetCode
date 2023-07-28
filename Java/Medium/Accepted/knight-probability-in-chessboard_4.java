class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        int[][] dirs = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        double[][][] dp = new double[k+1][n][n];
        dp[0][row][column] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    for (int[] dir : dirs) {
                        int x = j + dir[0];
                        int y = l + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            dp[i][j][l] += dp[i-1][x][y];
                        }
                    }
                }
            }
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += dp[k][i][j];
            }
        }
        return sum / Math.pow(8, k);
    }
}