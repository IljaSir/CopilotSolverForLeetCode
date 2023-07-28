class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        dfs(grid, visited, row, col, grid[row][col]);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 1) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    public void dfs(int[][] grid, int[][] visited, int row, int col, int color) {
        visited[row][col] = 1;
        int m = grid.length;
        int n = grid[0].length;
        if(row == 0 || col == 0 || row == m - 1 || col == n - 1 || grid[row - 1][col] != color || grid[row + 1][col] != color || grid[row][col - 1] != color || grid[row][col + 1] != color) {
            visited[row][col] = 2;
        }
        if(row - 1 >= 0 && visited[row - 1][col] == 0 && grid[row - 1][col] == color) {
            dfs(grid, visited, row - 1, col, color);
        }
        if(row + 1 < m && visited[row + 1][col] == 0 && grid[row + 1][col] == color) {
            dfs(grid, visited, row + 1, col, color);
        }
        if(col - 1 >= 0 && visited[row][col - 1] == 0 && grid[row][col - 1] == color) {
            dfs(grid, visited, row, col - 1, color);
        }
        if(col + 1 < n && visited[row][col + 1] == 0 && grid[row][col + 1] == color) {
            dfs(grid, visited, row, col + 1, color);
        }
    }
}