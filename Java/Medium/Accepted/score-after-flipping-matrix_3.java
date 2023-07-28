class Solution {
    public int matrixScore(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
            }
            sum = Math.max(sum, m - sum);
            res += sum * (1 << (n - j - 1));
        }
        return res;
    }
}