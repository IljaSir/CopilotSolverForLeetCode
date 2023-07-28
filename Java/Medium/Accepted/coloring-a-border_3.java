class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] border = new boolean[m][n];
        int oldColor = grid[row][col];
        dfs(grid, row, col, color, oldColor, visited, border, directions);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (border[i][j]) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    private void dfs(int[][] grid, int row, int col, int color, int oldColor, boolean[][] visited, boolean[][] border, int[][] directions) {
        visited[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                border[row][col] = true;
                continue;
            }
            if (grid[newRow][newCol] != oldColor) {
                border[row][col] = true;
                continue;
            }
            if (visited[newRow][newCol]) {
                continue;
            }
            dfs(grid, newRow, newCol, color, oldColor, visited, border, directions);
        }
    }
}