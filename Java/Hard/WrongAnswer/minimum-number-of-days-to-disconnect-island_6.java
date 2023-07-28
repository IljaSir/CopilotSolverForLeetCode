class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        int islandNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islandNum++;
                    dfs(grid, visited, i, j, dirs);
                }
            }
        }
        if (islandNum > 1) return 0;
        if (islandNum == 0) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 2;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int[][] dirs) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) continue;
            dfs(grid, visited, x, y, dirs);
        }
    }
}