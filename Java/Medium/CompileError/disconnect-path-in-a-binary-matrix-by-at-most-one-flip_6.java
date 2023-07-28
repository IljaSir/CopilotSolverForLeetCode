class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        boolean[][] visited1 = new boolean[m][n];
        boolean[][] visited2 = new boolean[m][n];
        int[][] direction = new int[][] {{1, 0}, {0, 1}};
        return dfs(grid, 0, 0, visited, direction) && dfs(grid, 0, 0, visited1, direction) && dfs(grid, m - 1, n - 1, visited2, direction);
    }
    
    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited, int[][] direction) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                if (dfs(grid, nextRow, nextCol, visited, direction)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int[][] grid, int row, int col, int[][] visited, int[][] direction) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == 1 && visited[nextRow][nextCol] < 2) {
                visited[nextRow][nextCol]++;
                if (dfs(grid, nextRow, nextCol, visited, direction)) {
                    return true;
                }
                visited[nextRow][nextCol]--;
            }
    }
}