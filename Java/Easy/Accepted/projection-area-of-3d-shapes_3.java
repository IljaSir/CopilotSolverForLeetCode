class Solution {
    public int projectionArea(int[][] grid) {
        
        int xz = 0;
        int yz = 0;
        int xy = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    xy++;
                }
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            xz += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            yz += max;
        }
        return xz + yz + xy;
    }
}