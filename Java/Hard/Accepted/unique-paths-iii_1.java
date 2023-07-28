class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int startRow = 0;
        int startCol = 0;
        int empty = 1;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                } else if (grid[row][col] == 0) {
                    empty++;
                }
            }
        }
        return dfs(grid, startRow, startCol, empty);
    }

    private int dfs(int[][] grid, int row, int col, int empty) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) {
            return 0;
        }
        if (grid[row][col] == 2) {
            return empty == 0 ? 1 : 0;
        }
        grid[row][col] = -1;
        int paths = dfs(grid, row + 1, col, empty - 1) + dfs(grid, row - 1, col, empty - 1) + dfs(grid, row, col + 1, empty - 1) + dfs(grid, row, col - 1, empty - 1);
        grid[row][col] = 0;
        return paths;
    }
}