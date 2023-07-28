class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        // find first island
        int i = 0;
        int j = 0;
        boolean found = false;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        // mark first island
        markIsland(grid, i, j);
        // find second island
        found = false;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        // expand second island
        return expandIsland(grid, i, j);
    }

    private void markIsland(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        markIsland(grid, i - 1, j);
        markIsland(grid, i + 1, j);
        markIsland(grid, i, j - 1);
        markIsland(grid, i, j + 1);
    }

    private int expandIsland(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return -1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return -1;
        }
        grid[i][j] = 1;
        int a = expandIsland(grid, i - 1, j);
        int b = expandIsland(grid, i +
    }
}