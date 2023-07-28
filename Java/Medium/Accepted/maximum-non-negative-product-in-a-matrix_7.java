class Solution {
    public int maxProductPath(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        long[][] min = new long[n][m];
        long[][] max = new long[n][m];
        long mod = (long)1e9 + 7;
        min[0][0] = grid[0][0];
        max[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            min[i][0] = min[i - 1][0] * grid[i][0];
            max[i][0] = max[i - 1][0] * grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            min[0][i] = min[0][i - 1] * grid[0][i];
            max[0][i] = max[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long[] tmp = new long[4];
                tmp[0] = min[i - 1][j] * grid[i][j];
                tmp[1] = min[i][j - 1] * grid[i][j];
                tmp[2] = max[i - 1][j] * grid[i][j];
                tmp[3] = max[i][j - 1] * grid[i][j];
                Arrays.sort(tmp);
                min[i][j] = tmp[0];
                max[i][j] = tmp[3];
            }
        }
        return max[n - 1][m - 1] < 0 ? -1 : (int)(max[n - 1][m - 1] % mod);
    }
}