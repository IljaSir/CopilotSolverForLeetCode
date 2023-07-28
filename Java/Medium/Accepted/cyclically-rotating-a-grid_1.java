class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int r1 = 0, r2 = m - 1;
        int c1 = 0, c2 = n - 1;
        while (r1 < r2 && c1 < c2) {
            int size = (r2 - r1 + 1) * 2 + (c2 - c1 + 1) * 2 - 4;
            int kk = k % size;
            for (int i = 0; i < kk; i++) {
                int tmp = grid[r1][c1];
                for (int j = c1; j < c2; j++) {
                    grid[r1][j] = grid[r1][j + 1];
                }
                for (int j = r1; j < r2; j++) {
                    grid[j][c2] = grid[j + 1][c2];
                }
                for (int j = c2; j > c1; j--) {
                    grid[r2][j] = grid[r2][j - 1];
                }
                for (int j = r2; j > r1; j--) {
                    grid[j][c1] = grid[j - 1][c1];
                }
                grid[r1 + 1][c1] = tmp;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return grid;
    }
}