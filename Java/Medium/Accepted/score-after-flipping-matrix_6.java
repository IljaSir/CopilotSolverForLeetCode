class Solution {
    public int matrixScore(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int c = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    c++;
                }
            }
            ans += Math.max(c, m - c) * (1 << (n - j - 1));
        }
        return ans;
    }
}