class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        double[][] dp = new double[n][n];
        dp[row][column] = 1;
        int[][] dirs = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
        for (int step = 0; step < k; step++) {
            double[][] dp2 = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int r2 = r + dir[0];
                        int c2 = c + dir[1];
                        if (r2 >= 0 && r2 < n && c2 >= 0 && c2 < n) {
                            dp2[r2][c2] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row: dp) {
            for (double x: row) {
                ans += x;
            }
        }
        return ans;
    }
}