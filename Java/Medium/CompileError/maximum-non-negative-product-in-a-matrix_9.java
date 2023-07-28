class Solution {
    public int maxProductPath(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int mod = 1000000007;
        long[][] maxdp = new long[m][n];
        long[][] mindp = new long[m][n];
        maxdp[0][0] = mindp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            maxdp[i][0] = mindp[i][0] = maxdp[i - 1][0] * grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            maxdp[0][i] = mindp[0][i] = maxdp[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long[] maxmin = maxMin(maxdp[i - 1][j], maxdp[i][j - 1], mindp[i - 1][j], mindp[i][j - 1]);
                maxdp[i][j] = maxmin[0] * grid[i][j];
                mindp[i][j] = maxmin[1] * grid[i][j];
            }
        }
        return maxdp[m - 1][n - 1] < 0 ? -1 : (int)(maxdp[m - 1][n - 1] % mod);
    }
}