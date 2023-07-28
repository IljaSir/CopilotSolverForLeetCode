class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int[][] result = new int[m][n];
        int oldColor = grid[row][col];
        dfs(grid, visited, result, row, col, oldColor, color);
        return result;
    }
}