class Solution {
    public int maxProductPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = min[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            max[0][j] = max[0][j - 1] * grid[0][j];
            min[0][j] = min[0][j - 1] * grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long[] tmp = new long[4];
                tmp[0] = max[i - 1][j] * grid[i][j];
                tmp[1] = max[i][j - 1] * grid[i][j];
                tmp[2] = min[i - 1][j] * grid[i][j];
                tmp[3] = min[i][j - 1] * grid[i][j];
                max[i][j] = Arrays.stream(tmp).max().getAsLong();
                min[i][j] = Arrays.stream(tmp).min().getAsLong();
            }
        }
        return max[m - 1][n - 1] < 0 ? -1 : (int) (max[m - 1][n - 1] % 1000000007);
    }
}