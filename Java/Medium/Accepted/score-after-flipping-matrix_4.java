class Solution {
    public int matrixScore(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) {
                    c++;
                }
            }
            if (c < m - c) {
                for (int j = 0; j < m; j++) {
                    grid[j][i] = grid[j][i] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int p = 1;
            for (int j = n - 1; j >= 0; j--) {
                sum += grid[i][j] * p;
                p *= 2;
            }
        }
        return sum;
    }
}