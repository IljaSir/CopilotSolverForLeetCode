class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }
        int gold = grid[row][col];
        grid[row][col] = 0;
        int max = Math.max(dfs(grid, row - 1, col), dfs(grid, row + 1, col));
        max = Math.max(max, dfs(grid, row, col - 1));
        max = Math.max(max, dfs(grid, row, col + 1));
        grid[row][col] = gold;
        return max + gold;
    }
}