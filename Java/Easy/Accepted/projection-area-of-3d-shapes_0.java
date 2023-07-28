class Solution {
    public int projectionArea(int[][] grid) {
        
        int top = 0;
        int front = 0;
        int side = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > 0) {
                    top++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            front += max;
        }
        for (int j = 0; j < grid.length; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            side += max;
        }
        return top + front + side;
    }
}