class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        int[][] dirs = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        double[][] dp = new double[n][n];
        dp[row][column] = 1;
        for (int i = 0; i < k; i++) {
            double[][] dp2 = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                            dp2[nr][nc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row1 : dp) {
            for (double x : row1) {
                ans += x;
            }
        }
        return ans;
    }
}