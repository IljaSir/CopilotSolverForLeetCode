class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, visited);
    }
    
    private boolean dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return false;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        visited[i][j] = true;
        if (grid[i][j] == '(') {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (grid[i][j] == ')') {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (grid[i][j] == '[') {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i - 1, j, visited);
        } else if (grid[i][j] == ']') {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i - 1, j, visited);
        } else if (grid[i][j] == '{') {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i + 1, j, visited);
        } else {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i - 1, j, visited);
        }
    }
}