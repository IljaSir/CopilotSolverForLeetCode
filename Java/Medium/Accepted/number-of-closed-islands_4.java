class Solution {
    public int closedIsland(int[][] grid) {
        
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (isClosed(grid, i, j)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean isClosed(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean result = true;
        result &= isClosed(grid, i - 1, j);
        result &= isClosed(grid, i + 1, j);
        result &= isClosed(grid, i, j - 1);
        result &= isClosed(grid, i, j + 1);
        return result;
    }
}