class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        return dfs(grid, 0, 0, visited, dirs);
    }
    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited, int[][] dirs) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y]) {
                if (dir[0] == 1 && (grid[i][j] == 2 || grid[i][j] == 3 || grid[i][j] == 4)) {
                    if (grid[x][y] == 2 || grid[x][y] == 5 || grid[x][y] == 6) {
                        res |= dfs(grid, x, y, visited, dirs);
                    }
                } else if (dir[0] == -1 && (grid[i][j] == 2 || grid[i][j] == 5 || grid[i][j] == 6)) {
                    if (grid[x][y] == 2 || grid[x][y] == 3 || grid[x][y] == 4) {
                        res |= dfs(grid, x, y, visited, dirs);
                    }
                } else if (dir[1] == 1 && (grid[i][j] == 1 || grid[i][j] == 4 || grid[i][j] == 6)) {
                    if (grid[x][y] == 1 || grid[x][y] == 3 || grid[x][y] == 5) {
                        res |= dfs(grid, x, y, visited, dirs);
                    }
                } else if (dir[1] == -1 && (grid[i][j] == 1 || grid[i][j] == 3 || grid[i
    }
}