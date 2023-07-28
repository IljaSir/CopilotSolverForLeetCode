class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        dfs(grid, visited, row, col, grid[row][col], color, dirs);
        return grid;
    }
    
    public void dfs(int[][] grid, boolean[][] visited, int row, int col, int oldColor, int newColor, int[][] dirs) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] != oldColor) {
            return;
        }
        visited[row][col] = true;
        boolean isBorder = false;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] != oldColor) {
                isBorder = true;
            }
        }
        if (isBorder) {
            grid[row][col] = newColor;
        }
        for (int[] dir : dirs) {
            dfs(grid, visited, row + dir[0], col + dir[1], oldColor, newColor, dirs);
        }
    }
}