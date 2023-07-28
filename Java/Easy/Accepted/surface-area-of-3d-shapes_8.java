class Solution {
    public int surfaceArea(int[][] grid) {
        
        int n = grid.length;
        int surface = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    surface += 2 + 4 * v;
                    if (i > 0) {
                        surface -= Math.min(v, grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        surface -= Math.min(v, grid[i][j - 1]) * 2;
                    }
                }
            }
        }
        return surface;
    }
}