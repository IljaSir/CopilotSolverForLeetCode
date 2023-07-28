class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int c = grid[row][col];
        if (c == color) return grid;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, c, color, visited);
        return grid;
    }
    
    private void dfs(int[][] grid, int row, int col, int c, int color, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (visited[row][col]) return;
        if (grid[row][col] != c) return;
        visited[row][col] = true;
        dfs(grid, row + 1, col, c, color, visited);
        dfs(grid, row - 1, col, c, color, visited);
        dfs(grid, row, col + 1, c, color, visited);
        dfs(grid, row, col - 1, c, color, visited);
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
            grid[row][col] = color;
            return;
        }
        if (grid[row + 1][col] != c || grid[row - 1][col] != c || grid[row][col + 1] != c || grid[row][col - 1] != c) {
            grid[row][col] = color;
        }
    }
}