class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int startRow = 0;
        int startCol = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != -1) {
                    total++;
                }
                if(grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        return dfs(grid, startRow, startCol, total);
    }
    public int dfs(int[][] grid, int row, int col, int total) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) {
            return 0;
        }
        if(grid[row][col] == 2) {
            return total == 1 ? 1 : 0;
        }
        grid[row][col] = -1;
        int count = dfs(grid, row-1, col, total-1) + dfs(grid, row+1, col, total-1) + dfs(grid, row, col-1, total-1) + dfs(grid, row, col+1, total-1);
        grid[row][col] = 0;
        return count;
    }
}