class Solution {
    public int matrixScore(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int i = 1; i < cols; i++) {
            int count = 0;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 1) {
                    count++;
                }
            }
            if (count < rows - count) {
                for (int j = 0; j < rows; j++) {
                    grid[j][i] = 1 - grid[j][i];
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j] * Math.pow(2, cols - 1 - j);
            }
        }
        return sum;
    }
}