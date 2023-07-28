class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int empty = 1;
        int sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) empty++;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, empty);
    }
}