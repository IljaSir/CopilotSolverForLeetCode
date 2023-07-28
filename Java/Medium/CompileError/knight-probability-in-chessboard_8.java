class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        double[][] dp = new double[n][n];
        dp[row][column] = 1;
        int[][] dirs = {{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
        for (int i = 0; i < k; i++) {
            double[][] dp2 = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            dp2[nr][nc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row : dp) {
            for (double x : row) {
                ans += x;
            }
        }
        return ans;
    }
}