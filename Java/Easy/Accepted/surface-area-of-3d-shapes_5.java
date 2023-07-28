class Solution {
    public int surfaceArea(int[][] grid) {
        
        int n = grid.length;
        int surfaceArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    surfaceArea += v * 4 + 2;
                    if (i > 0) surfaceArea -= Math.min(grid[i - 1][j], v) * 2;
                    if (j > 0) surfaceArea -= Math.min(grid[i][j - 1], v) * 2;
                }
            }
        }
        return surfaceArea;
    }
}